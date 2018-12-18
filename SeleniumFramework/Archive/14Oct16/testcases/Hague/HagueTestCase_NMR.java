package com.whs.navigator.testcases.Hague;

import java.util.regex.Pattern;

import org.apache.bcel.generic.FREM;
import org.apache.commons.httpclient.methods.GetMethod;
import org.eclipse.jetty.websocket.common.extensions.FrameDebugExtension;
import org.jboss.netty.handler.codec.frame.FrameDecoder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.whs.navigator.commonUtil.FrameworkUtil;
import com.whs.navigator.commonUtil.LoggerUtil;
import com.whs.navigator.commonUtil.WebDriverUtil;
import com.whs.navigator.commonUtil.WebObjectUtil;
import com.whs.navigator.pagefactory.EVDC_FirewallPageFactory;
import com.whs.navigator.pagefactory.EVDC_OverviewPageFactory;
import com.whs.navigator.pagefactory.EVDC_StorageProfilePageFactory;
import com.whs.navigator.pagefactory.EVDC_VM_PageFactory;
import com.whs.navigator.pagefactory.HaguePageFactory_NMR;
import com.whs.navigator.pagefactory.HomePageFactory_old;
import com.whs.navigator.pagefactory.IACPageFactory_NMR;
import com.whs.navigator.pagefactory.LoadBalancerPageFactory;
import com.whs.navigator.pagefactory.UserPermissionPageFactory;


public class HagueTestCase_NMR {

	public static HaguePageFactory_NMR Hague = new HaguePageFactory_NMR();
    public static UserPermissionPageFactory UserPermission = new UserPermissionPageFactory();
     public static HomePageFactory_old Home = new HomePageFactory_old();
     public static EVDC_OverviewPageFactory EVDC_OverviewPF= new EVDC_OverviewPageFactory();
     public static LoadBalancerPageFactory LoadBalancer = new LoadBalancerPageFactory();
     public static EVDC_VM_PageFactory EVDC_VMPF=new EVDC_VM_PageFactory();
     public static EVDC_StorageProfilePageFactory EVDC_Storage = new EVDC_StorageProfilePageFactory();
     public static EVDC_FirewallPageFactory Firewall = new EVDC_FirewallPageFactory();
    public static TicketTestCase Ticket = new TicketTestCase();
    public static IACPageFactory_NMR IAC_PF = new IACPageFactory_NMR();
   
   
   
   
   
  
    
  
    
    
   
    
   
  
    
 
  
//// Methods
    
  
 
  
    
    
    
     
   
  
  

  
 
 
  
  
  
 
  
  






//update each @test result in custom result file
		@AfterMethod
		public static void afterEachMethod(){
			FrameworkUtil.updateTestCaseStatusinResult();
			FrameworkUtil.sTestExecutionStatus = true;
			
		}
}
	