package com.Pcitc.AppAutomationTest.testCases;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.Pcitc.AppAutomationTest.pagesHelper.Config;
import com.Pcitc.AppAutomationTest.pagesHelper.PageFuntion;
import com.Pcitc.AppAutomationTest.utils.Action;
import com.Pcitc.AppAutomationTest.utils.DataHandle;
import com.Pcitc.AppAutomationTest.utils.Log;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DebugTest
{	public  static  DesiredCapabilities capabilities =null;
	public static AppiumDriver  wd=null;
	public static Action action=null;
	public static String plantForm="Io";
	public static void main(String[] args) throws MalformedURLException {
		
		if (plantForm.equals("Ios"))
		{
			System.out.print("333");
			 capabilities = new DesiredCapabilities();
//			capabilities.setCapability("locationServicesEnabled", Config.locationServicesEnabled);//	这个capability主要用于是否启用定位服务，这个只用于模拟器上，真机无效。	
			capabilities.setCapability("nativeInstrumentsLib", Config.calendarFormat);//设置这个capability可以使用本地instrumentsLib，设置代码：
			capabilities.setCapability("calendarFormat", Config.calendarFormat);//只对模拟器起作用-用户设置模拟器日期显示格式
			capabilities.setCapability("autoAcceptAlerts", "true");//autoAcceptAlerts（非常实用）使用这个capability可以自动接受alert
//			//弹窗，比如定位弹窗、获取短信和联系人弹窗，读取照片弹窗等，默认值是false，如果测试app会出现alert建议		
			capabilities.setCapability("deviceName", "iPhone Simulator");
		    capabilities.setCapability("platformVersion", "9.3");
		    capabilities.setCapability("platformName", "iOS");
		    capabilities.setCapability("deviceName", "iPhone Simulator");
		    capabilities.setCapability("app","/project/eclipse/AppAutomationTest/File/apps/MobileCooperativeOffice.app");
		    wd = new IOSDriver(new URL(Config.URL),
		  	      capabilities);
		    
		}
		else {
			System.out.print("安卓环境");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("appium-version", "1.0");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "4.4");
			capabilities.setCapability("deviceName", "Samsung Galaxy S5 - 4.4.4 - API 19 - 1080x1920");
			capabilities.setCapability("app", "/project/eclipse/AppAutomationTest/File/apps/xy.apk");
			capabilities.setCapability("appPackage", "cn.cooperative");
			capabilities.setCapability("appActivity", "cn.cooperative.activity.LoginActivity");
			wd = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
			wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
				 action=new Action(wd);
//				登陆
				WebElement Text_useNamae= wd.findElement(By.id("cn.cooperative:id/username")); 
				Text_useNamae.sendKeys("ying.jing");
				
				WebElement Text_Password= wd.findElement(By.id("cn.cooperative:id/password"));
				Text_Password.sendKeys("123");
						
				WebElement button_Commit=wd.findElement(By.id("cn.cooperative:id/loginbutton"));
				action.tap(button_Commit, 800);
				
//				找到指定模块并进入
				WebElement mode=wd.findElement(By.xpath("//android.widget.TextView[starts-with(@text,'客户管理')]"));	
				action.tap(mode, 800);
			
			
				select();
		}
	
	}
	public static  void select()
	{
		WebElement add=wd.findElement(By.id("cn.cooperative:id/business_add"));	
		action.tap(add, 800);
		
		WebElement mode=wd.findElement(By.id("cn.cooperative:id/tv_IsGroup"));	
		action.tap(mode, 800);
		
		wd.switchTo().alert().accept();
	
		

	}
}
