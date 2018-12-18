package com.whs.navigator.testcases.Others;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
import com.whs.navigator.pagefactory.CommonPageFactory;
import com.whs.navigator.pagefactory.DraasPageFactory;
import com.whs.navigator.pagefactory.EM7PageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_StorageProfilePageFactory;
import com.whs.navigator.pagefactory.FormPageFactory;

public class LorienTestCase_Sukur {


		public static EVDC_StorageProfilePageFactory EVDC_Storage = new EVDC_StorageProfilePageFactory();
		public static EVDC_OverviewPageFactory EVDC_OverviewPF = new EVDC_OverviewPageFactory();
		public static CommonPageFactory Common = new CommonPageFactory();
		
		
		/*==============================================================
		TestScript 		: validateTierPointdisplayInsteadOfWindstreamInStorageProfilePageTierToolTips
		Manual TestCase	: (QAT-1551)Verify Tier point displays in storage profile tool tips instead of windstream
		Description		: Verify Tier point displays in storage profile tool tips instead of windstream
		Author 			: Sukur Babu
		Creation Date 	: 11/07/2016
		Pre-Requisites	:
		Revision History:
		
		==============================================================*/
		@Test(priority=1)
		public void validateTierPointdisplayInsteadOfWindstreamInStorageProfilePageTierToolTips(){
			try{
				WebDriver driver = WebDriverUtil.getDriver();
				PageFactory.initElements(driver, EVDC_Storage);
				PageFactory.initElements(driver, EVDC_OverviewPF);
			
				FrameworkUtil.sTestCaseName = "Lorien_QAT-1551validateTierPointdisplayInsteadOfWindstreamInStorageProfilePageTierToolTips";
				FrameworkUtil.sManualTestCaseName="Verify Tier point displays in storage profile tool tips instead of windstream";
				FrameworkUtil.updateTestCaseNameinResult(FrameworkUtil.sTestCaseName,FrameworkUtil.sManualTestCaseName);
				//Read the required data from properties file
				String sExpWindStreamText=(String)FrameworkUtil.dictPropertyData.get("NAV.STORAGE.PROFILE.PAGE.WINDSTREAM.TOOLTIP.TEXT");
				String sExpTierPointText=(String)FrameworkUtil.dictPropertyData.get("NAV.STORAGE.PROFILE.PAGE.TIERPOINT.TOOLTIP.TEXT");
				String sActToolTipMsg;
				LoginTestCase_Old1.LoginAsQaautoUser();
				WebObjectUtil.clickElement(EVDC_OverviewPF.getNav_EVDCname());
			    WebObjectUtil.clickElement(EVDC_Storage.getNav_StorageLink());
			    WebObjectUtil.explicitWait(5);
			    
			   // WebElement wb = driver.findElement(By.xpath("//span[contains(text(),'Capacity Tier - Encrypted')]/../span/span"));
			    //WebObjectUtil. getToolTipsMsg(wb, sExpWindStreamText);

			    //boolean s=WebObjectUtil.getToolTipsMsg(EVDC_Storage.getNav_CapcityTierToolTip(), sExpWindStreamText);
				sActToolTipMsg=EVDC_Storage.getNav_CapcityTierToolTip().getAttribute("innerHTML");
				//driver.findElement(By.xpath("//span[contains(text(),'Capacity Tier - Encrypted')]/../span/span")).getText()
				if(sActToolTipMsg.contains(sExpWindStreamText)&&!sActToolTipMsg.contains(sExpTierPointText))
				{
					FrameworkUtil.updateCustomResultBasedOnStatus(false,sActToolTipMsg +" is displayed in Capacity Tier  section tool tip where Windstream text there instead of TierPoint");
				}
				else
				{
					FrameworkUtil.updateCustomResultBasedOnStatus(true,sActToolTipMsg +" is displayed Capacity Tier  section tool tip where Windstream text is not there. But, TierPoint is displayed as expected");
				}
				
				sActToolTipMsg=EVDC_Storage.getNav_CapcityTierEncryptedToolTip().getAttribute("innerHTML");
				if(sActToolTipMsg.contains(sExpWindStreamText))
				{
					FrameworkUtil.updateCustomResultBasedOnStatus(false,sActToolTipMsg +" is displayed in Capacity Tier Encrypted section tool tip where Windstream text there instead of TierPoint");
				}
				else
				{
					FrameworkUtil.updateCustomResultBasedOnStatus(true,sActToolTipMsg +" is displayed Capacity Tier Encrypted section tool tip where Windstream text is not there. But, TierPoint is displayed as expected");
				}
				
				sActToolTipMsg=EVDC_Storage.getNav_NonReplicatedTierToolTip().getAttribute("innerHTML");
				if(sActToolTipMsg.contains(sExpWindStreamText))
				{
					FrameworkUtil.updateCustomResultBasedOnStatus(false,sActToolTipMsg +" is displayed in Non Replicated section tool tip where Windstream text there instead of TierPoint");
				}
				else
				{
					FrameworkUtil.updateCustomResultBasedOnStatus(true,sActToolTipMsg +" is displayed Non Replicated Encrypted section tool tip where Windstream text is not there. But, TierPoint is displayed as expected");
				}
				
				
				LoginTestCase_Old1.nav_Logout();
			}
			catch(Exception e)
			{
				LoggerUtil.log_type_error("issue with- validateTierPointdisplayInsteadOfWindstreamInStorageProfilePageTierToolTips Test Case" );
				LoggerUtil.log_type_error(e.getMessage());
				FrameworkUtil.writeCustomResult(FrameworkUtil.stepNo(), FrameworkUtil.sElementName , "Exception occured", "fail", e.getMessage()+"null");
			}
		}
//__________________________________________________________________________________________________________

@AfterMethod
public void afterMethod(){
	FrameworkUtil.updateTestCaseStatusinResult();
	FrameworkUtil.sTestExecutionStatus=true;
}
}
