package com.whs.navigator.testcases;

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
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
import com.whs.navigator.pagefactory.FirewallPageFactory;

public class FirewallRuleTestCase {
	public static EVDC_FirewallPageFactory Firewall = new EVDC_FirewallPageFactory();
	public static FirewallPageFactory FirewallRule = new FirewallPageFactory();
	public static CommonPageFactory Common = new CommonPageFactory();

	/*==============================================================
	TestScript  	: verifyFireWallRuleEditDisabled
	Manual TestCase	: QAT-726-WCP_4577_TC_1.0_Firewall rule-> System defined rule validation
	Description		: Verify that Disable Editing of rules when destination is "Any Less Secured network" 
	Author 			: Priyanka R
	Creation Date 	: 04/04/2016
	Pre-Requisites	: 
	Release         : Matheson
	Revision History:
	=================================================================*/
			@Test(priority=3)
			public void verifyFireWallRuleEditDisabled()
			{
				int iRow=1,i=0,iRowLength=0;
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Firewall);
				PageFactory.initElements(driver, FirewallRule);
				PageFactory.initElements(driver, Common);
				
				try{
					String sUserName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTMASH4077.USERID.POTTERS");
					String sPassword = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTMASH4077.PWD.POTTERS");
					//String sInterfaceName = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACENAME.INTERFACE1");
					//String sInterfaceDesc = (String)FrameworkUtil.dictPropertyData.get("NAV.FIREWALL.INTERFACE1.DESCRIPTION");
					
					String sInterfaceName = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTMASH4077.FIREWALL.INTERFACENAME.INTERFACE1");
					String sInterfaceDesc = (String)FrameworkUtil.dictPropertyData.get("NAV.TSTMASH4077.FIREWALL.INTERFACE1.DESCRIPTION");
					String sInterDestination =(String)FrameworkUtil.dictPropertyData.get("NAV.TSTMASH4077.FIREWALL.INTERFACE1.DESTINATION");
					
					FrameworkUtil.sTestCaseName = "verifyFireWallRuleEditDisabled";
					FrameworkUtil.sManualTestCaseName="QAT-726-WCP_4577_TC_1.0_Firewall rule-> System defined rule validation";
			       	FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
			        //Login to Navigator portlet 
				    //LoginTestCase.nav_Login(sUserName,sPassword);
			       	LoginTestCase_Old1.LoginAsPottersUser();
			        // navigating to the firewall page
					EVDC_FirewallTestCase.NavigateToFirewallPage();
					expandInterface(sInterfaceName,sInterfaceDesc);
					WebObjectUtil.explicitWait(3);
					//updated the below code by QAA03 on 08/03/2016
					//int iRowLength=WebTableUtil.getRowCount(FirewallRule.getNav_Interface1Table());
					CustomWebElementUtil.loadCustomElement(FirewallRule.getNav_Interface1Table(), "table");
					iRowLength=CustomWebElementUtil.iRowCount;
					iRow =CustomWebElementUtil.getRowByCellText(sInterDestination, 1);
					//WebObjectUtil.explicitWait(5);
					//while(i<iRowLength)
					if(iRow!=0)
					{
					WebElement wFWExpander=WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.RULE.EXPANDER", "PARAMETER_ROWNUMBER",iRow+"");
					//WebObjectUtil.explicitWait(5);
					WebObjectUtil.clickElement(wFWExpander);
					WebObjectUtil.explicitWait(5);
					//if(FireWall.getNav_EditSuccessMsg().isDisplayed())
					if(Common.getNav_UsrFeedBack().isDisplayed())
					{
						LoggerUtil.log_type_info("You Cannot currently edit system defined rules");
						FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName ,"" , "pass","Verified");
                        //break;
					}
					//else
					//{
						//i++;
					//}
					//break;
					}
	                
					LoginTestCase_Old1.nav_Logout();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				LoggerUtil.log_type_error("catch block:" + FrameworkUtil.sElementName);
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "navContactUsCreateticket", "warn", "catch block:" +e.getMessage());  
			}

}
			
			/*====================================================================================================
			Method Name 	: expandInterface
			Description		: Expand interface based on values of interface name and description
			Ex:sInterfaceName=Interface - 1 and sInterfaceDescription=Internal - tstqaauto-VLANabc
			Author 			: Sukur Babu. B
			Creation Date 	: 21/03/2016
			Pre-Requisites	:
			Revision History:
			====================================================================================================*/
			public static boolean expandInterface(String sInterfaceName,String sInterfaceDescription)
			{
				int iintferRow,iintferCol;
				int iReqInterfaceRow = 0;
				boolean bReqInterfaceFlag=false;
//				String sInterfaceText="Interface - 1",sInterfaceDescriptionText="Outside - outside",;
//				String sInterfaceText="Interface - 2",sInterfaceDescriptionText="Internal - tstqaauto-VLANabc",sTempText;
//				String sInterfaceText="Global Implicit rule",sInterfaceDescriptionText="",sTempText;
				String sTempText;
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, Firewall);
				
				WebElement wIntFaceElement;
				/*LoginTestCase.LoginAsQaautoUser();
				EVDC_FirewallTestCase.NavigateToFirewallPage();*/
				int iInterfaceCntinPg=WebTableUtil.getRowCount(Firewall.getNav_FirewallTable());
				System.out.println("Number Of interface in the page "+iInterfaceCntinPg);
				int iinterfaceColCnt=WebTableUtil.getColumnCount(Firewall.getNav_FirewallTable(), 1);
				System.out.println("Firewall table column count is "+iinterfaceColCnt);
				
				
				for( iintferRow=1;iintferRow<=iInterfaceCntinPg;iintferRow++)
				{
					for(iintferCol=1;iintferCol<=iinterfaceColCnt;iintferCol++)
					{
						if(WebTableUtil.getColumnCount(Firewall.getNav_FirewallTable(), iintferRow)>1){
							
							sTempText=WebTableUtil.getCellData(Firewall.getNav_FirewallTable(), iintferRow, iintferCol);
														
							if(sTempText.equalsIgnoreCase(sInterfaceName)){
								sTempText=WebTableUtil.getCellData(Firewall.getNav_FirewallTable(), iintferRow, iintferCol+1);
								if(!sTempText.isEmpty()){
								if(sTempText.equalsIgnoreCase(sInterfaceDescription)){
									System.out.println("Interface " +sInterfaceName+" found at row "+iintferRow+" and column "+iintferCol);
									iReqInterfaceRow=iintferRow;
									bReqInterfaceFlag=true;
									break;
							}
							}
							}
						}
						else if(WebTableUtil.getColumnCount(Firewall.getNav_FirewallTable(), iintferRow)==1){
							sTempText=WebTableUtil.getCellData(Firewall.getNav_FirewallTable(), iintferRow, 1);
							if(sTempText.equalsIgnoreCase(sInterfaceName)){
								iReqInterfaceRow=iintferRow;
								bReqInterfaceFlag=true;
								break;
							}
						}
					}
					 
				}
				if(bReqInterfaceFlag){
					WebElement wInterfaceExpandWebElement = WebObjectUtil.getWebElementFromDynamicLocator("xpath", "EVDC.FIREWALL.EXPANDER","PARAMETER_ROWNUMBER",iReqInterfaceRow+"");
					wInterfaceExpandWebElement.click();
					WebObjectUtil.explicitWait(15);
					return true;
				}else{
					FrameworkUtil.updateCustomResultBasedOnStatus(false, "Issue in expanding Firewall interface");
					return false;
				}
				
			}
			
			//update each @test result in custom result file
			@AfterMethod
			public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			}
}