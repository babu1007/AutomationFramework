package com.whs.navigator.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.CustomWebElementUtil;
import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.commonUtil.WebTableUtil;
import com.whs.navigator.pagefactory.CatalogPageFactory;
//import com.whs.navigator.pagefactory.EVDCPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_AdvancedActions_PageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;

public class DeleteTestCase_old06102016 {
	public static CatalogPageFactory Catalog =new CatalogPageFactory();
	//public static EVDCPageFactory EVDC= new EVDCPageFactory();
	public static EVDC_OverviewPageFactory EVDC_OverviewPF= new EVDC_OverviewPageFactory();
	public static EVDC_VM_PageFactory EVDC_VMPF=new EVDC_VM_PageFactory();
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
		
		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.USERID.AROLEA");
		String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.PWD.AROLEA");
		deleteOldVMs(sUserName,sPassword);
		
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTO");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.PWD.QAAUTO");
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

		String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.USERID.AROLEA");
		String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.HOSTEDSOLUTIONS.PWD.AROLEA");
	  //delete Private Catalog
	  deleteCatalog(sUserName,sPassword,false);
	  
		
		sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.USERID.QAAUTO");
		sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTQAAUTO.PWD.QAAUTO");
		deleteCatalog(sUserName,sPassword,false);

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
	 public static void deleteCatalog(String sUserName,String sPassword,boolean bDeleteManage)
	 {
	  WebDriver driver = WebDriverUtil.getDriver();
	  PageFactory.initElements(driver, Catalog);
	  
	  int iRowNum=0,iCatalogTableRowCount;
	  String sCatalogName,sCurrentDate,sTodayDate,sCatalogtempname,sConfirmMsg,sActualMsg,sCatalogImgName,sErrMessage,sExpanderXpath,sDeleteXpath;
	  WebElement expander = null,wDeletebutton = null;
	  int rowno=1,iMaxIteration=0,iCatalogNameColIndex,iCatalogImgColIndex;
	  boolean bConfirmMsg = false;
	  LoginTestCase_Old1.nav_Login(sUserName,sPassword);
	  
	  try {
		  
		  //Navigating to Catalog Page
		  navigateCatalogPage();
		  
		  sCatalogtempname = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDVM.NAME");
		  sConfirmMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.DELETEVM.CONFIRMMSG");
		  sExpanderXpath = "NAV.CATALOG.PRIVATE.EXPANDER";
		  sDeleteXpath = "NAV.CATALOG.PRIVATE.EXPANDER.DELETE";
		  iCatalogNameColIndex=6;
		  iCatalogImgColIndex=2;
		  WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
		  WebObjectUtil.explicitWait(5);


		  //WebTableUtil.printEachCellText(Catalog.getNav_CatalogPrivateWebTable());
			sTodayDate = FrameworkUtil.date_yyyyMMdd();
			//iCatalogTableRowCount = WebTableUtil.getRowCount(Catalog.getNav_CatalogPrivateWebTable());
			CustomWebElementUtil.loadCustomElement(Catalog.getNav_CatalogPrivateWebTable(), "table");
			iCatalogTableRowCount = CustomWebElementUtil.iRowCount;
			
			  
			  if (bDeleteManage){
				  sExpanderXpath = "NAV.CATALOG.PRIVATE.MANAGE.EXPANDER";
				  sDeleteXpath = "NAV.CATALOG.PRIVATE.MANAGE.EXPANDER.DELETE";
				  iCatalogNameColIndex=2;
				  iCatalogImgColIndex=7;
				  WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateManageCatalogBtn());
				  WebObjectUtil.explicitWait(10);
					CustomWebElementUtil.loadCustomElement(Catalog.getNav_CatalogPrivateManageCatalogWebTable(), "table");
					iCatalogTableRowCount = CustomWebElementUtil.iRowCount;
			  }
			//for (int rowno=1; rowno<=iCatalogTableRowCount; rowno=rowno+3){
			//for (int rowno=1; rowno<=iCatalogTableRowCount; rowno++){
			while(iCatalogTableRowCount>0 || iMaxIteration >= 50)
			{
				
				
				iMaxIteration++;
				if (iRowNum<10){
					iRowNum++;
				}
				//sCatalogName =WebTableUtil.getCellData(Catalog.getNav_CatalogPrivateWebTable(), rowno, 3);
				sCatalogName =CustomWebElementUtil.getCellData(iRowNum,iCatalogNameColIndex);
				sCatalogImgName =CustomWebElementUtil.getCellData(iRowNum,iCatalogImgColIndex);
				if (sCatalogName.contains(sCatalogtempname) && !sCatalogName.contains(sTodayDate)){
					//FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Delete Catalog" , "Catalog Name ", "Done", sCatalogName);
//					sExpanderXpath = "//div[@id='pvtObjGrid-body']//tr["+iRowNum+"]//tr[1]//div[@class='x-grid-row-expander']";
//					expander = WebObjectUtil.GetWebElement("xpath", sExpanderXpath, "Expander");

					expander = WebObjectUtil.getWebElementFromDynamicLocator("xpath",sExpanderXpath,"PARAMETER_ROWNUMBER",iRowNum+"");
					WebObjectUtil.clickElement(expander);
					//WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateDeleteBtn());

					wDeletebutton = WebObjectUtil.getWebElementFromDynamicLocator("xpath", sDeleteXpath, "PARAMETER_ROWNUMBER", iRowNum+"");
					WebObjectUtil.clickElement(wDeletebutton);
					
					
					
					try {
						sConfirmMsg = sConfirmMsg + " " + sCatalogImgName + " ?";
						sActualMsg = Catalog.getNav_NewCatalogPopUpMessage().getText();
						bConfirmMsg = sActualMsg.contains(sConfirmMsg);
						FrameworkUtil.updateCustomResultBasedOnStatus(bConfirmMsg,sActualMsg);
						WebObjectUtil.clickElement(Catalog.getNav_NewCatalogPopUpOKBtn());
						WebObjectUtil.explicitWait(10);
									
						if(WebObjectUtil.isElementPresent(Catalog.getNav_ErrDialogBox())){
						    sErrMessage= Catalog.getNav_ErrDialogBox().getText();
							WebObjectUtil.clickElement(Catalog.getNav_CatalogPopUpOKBtn());
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Delete Catalog", "Catalog Name ", "warn", ""+sErrMessage);
						    //rowno++;
						}
						else{
						    FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Delete Catalog" , "Catalog Name ", "Done", sCatalogName);
						    //rowno=rowno-1;
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						System.out.println("could not delete private catalog" + sCatalogName + "  for row no:" +iRowNum );
					}
			       
			       
			       
					//System.out.println(sCatalogName + "row no:" +rowno );
			        WebDriverUtil.refreshBrowser();
					WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateLink());
					if (bConfirmMsg){
					iRowNum--;
					}
					/*if (rowno > 3){
						rowno = rowno -3;
					}
					iRowNum = iRowNum -1;
					iCatalogTableRowCount = iCatalogTableRowCount -3;
						
				
					*/
					
				}
				CustomWebElementUtil.loadCustomElement(Catalog.getNav_CatalogPrivateWebTable(), "table");
				iCatalogTableRowCount = CustomWebElementUtil.iRowCount;
				  if (bDeleteManage){
					  WebObjectUtil.clickElement(Catalog.getNav_CatalogPrivateManageCatalogBtn());
					  WebObjectUtil.explicitWait(10);
						CustomWebElementUtil.loadCustomElement(Catalog.getNav_CatalogPrivateManageCatalogWebTable(), "table");
						iCatalogTableRowCount = CustomWebElementUtil.iRowCount;
				  }
				
			}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
		  //Logging out from Navigator application
		  LoginTestCase_Old1.nav_Logout();
	  
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
	
			String sVMAppname, sTodayDate,sVMtempname,sRowText,sDeleteXpath,sDeleteString,sConfirmMsg;
			WebElement rowElement, wDeleteVM;
			int iRowNum=0,iEVDCTableRowCount,iDeleteColNo;
			boolean bDeleteStatus;
			WebDriver driver = WebDriverUtil.getDriver();
			PageFactory.initElements(driver,EVDC_OverviewPF);
			PageFactory.initElements(driver,EVDC_VMPF);
			PageFactory.initElements(driver,EVDC_Advanced);
			
			LoginTestCase_Old1.nav_Login(sUserName,sPassword);
			
			try {
				
			     sVMtempname = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.ADDVM.NAME");
				
				sConfirmMsg = (String)FrameworkUtil.dictPropertyData.get("NAV.EVDC.DELETEVM.CONFIRMMSG");
				//sDeleteXpath ="//table[contains(@id,'gridview-')]//tr[" + iRowNum + "]//tbody//td//a[text()='Delete']";
				WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCname(), EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine());
				WebObjectUtil.clickAndVerifyElement(EVDC_OverviewPF.getNav_EVDCOverviewVirtualMachine(),EVDC_VMPF.getNav_AddVMLink());
                WebObjectUtil.explicitWait(10);

				//WebTableUtil.printEachCellText(EVDC.getNav_VMWebTable());
				sTodayDate = FrameworkUtil.date_yyyyMMdd();
				//iEVDCTableRowCount = WebTableUtil.getRowCount(EVDC_VMPF.getNav_VMWebTable());
				CustomWebElementUtil.loadCustomElement(EVDC_VMPF.getNav_VMWebTableParent(), "table");
				iEVDCTableRowCount = CustomWebElementUtil.iRowCount;
				for (int rowno=iEVDCTableRowCount; rowno>=1; rowno=rowno-1){
					
				//sVMname =WebTableUtil.getCellData(EVDC_VMPF.getNav_VMWebTable(), rowno, 3);
					sVMAppname = CustomWebElementUtil.getCellData(rowno,3);
					if ((sVMAppname.length()<=2) ||( sVMAppname.equalsIgnoreCase("-"))) {
						rowElement = CustomWebElementUtil.getRowAsWebElement(rowno);
						deleteFailedVM(rowElement,rowno);
						sVMAppname = CustomWebElementUtil.getCellData(rowno,2);
						
					}else{
						if (sVMAppname.contains(sVMtempname.toLowerCase()) && !sVMAppname.contains(sTodayDate)){
							iRowNum = EVDC_VM_AdvancedActions.getRow_EVDC_VMTable(EVDC_VMPF.getNav_VMWebTable(),sVMAppname,"");
							FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Get VM and its State" , "VM Name and State ", "Done", EVDC_VM_AdvancedActions.sVMName + "//"+ EVDC_VM_AdvancedActions.sVMstatus);
							if (!EVDC_VM_AdvancedActions.sVMstatus.contentEquals("Stopped")&&!EVDC_VM_AdvancedActions.sVMstatus.equalsIgnoreCase("Failed")){
								//call stop VM method
								EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNum);
								EVDC_VM_TestCase.stopRunningVM(iRowNum);
								WebDriverUtil.refreshBrowser();
							}
							System.out.println( EVDC_VM_AdvancedActions.sVMName + "//"+ EVDC_VM_AdvancedActions.sVMstatus);
							if (!EVDC_VM_AdvancedActions.sVMstatus.equalsIgnoreCase("Failed")){
								EVDC_VM_AdvancedActions.expandVMbyRowNum(iRowNum);
								bDeleteStatus =EVDC_VM_AdvancedActions.verifyDeleteVM();
								if(bDeleteStatus)
								{
									//rowno=rowno-1;
									FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Delete VM" , "VM", "Done", sVMAppname);
								}
								else
								{
									FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), "Delete VM" , "VM", "warn", sVMAppname);
									//rowno++;
								}
							WebDriverUtil.refreshBrowser();
							}
							
						}
					}
					iRowNum = iRowNum+1;
					//iEVDCTableRowCount = WebTableUtil.getRowCount(EVDC_VMPF.getNav_VMWebTable());
					CustomWebElementUtil.loadCustomElement(EVDC_VMPF.getNav_VMWebTableParent(), "table");
					iEVDCTableRowCount = CustomWebElementUtil.iRowCount;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LoginTestCase_Old1.nav_Logout();	
				
		}


public static void deleteFailedVM(WebElement wTableRowAsWebElement, int iRowNo){
	

	String sRowText,sActualMsg,sConfirmMsg;
	WebElement  wDeleteVM;

	WebDriver driver = WebDriverUtil.getDriver();
	PageFactory.initElements(driver,EVDC_Advanced);
	
	try {
		sRowText = wTableRowAsWebElement.getText();
		if (sRowText.contains("Delete")){
			//verify text present on Delete dialog
			wDeleteVM = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.VM.VMTABLE.FAILEDVM", "PARAMETER_ROWNUMBER",iRowNo+"");
			WebObjectUtil.clickElement(wDeleteVM);
			WebObjectUtil.explicitWait(3);
			WebObjectUtil.clickElement(EVDC_Advanced.getNav_EVDCConfirmNewPopupOKBtn());
			WebObjectUtil.explicitWait(10);
			FrameworkUtil.updateCustomResultBasedOnStatus(true, "Delete Failed VM : " +EVDC_Advanced.getNav_EVDCSuccessMsg().getText());

			}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

//update each @Test result in custom result file
@AfterMethod
public void afterEachMethod(){
	FrameworkUtil.updateTestCaseStatusinResult();
	FrameworkUtil.sTestExecutionStatus = true;
}


}
