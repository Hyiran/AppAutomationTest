package com.Pcitc.AppAutomationTest.utils;

import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.Pcitc.AppAutomationTest.pagesHelper.Config;
import com.Pcitc.AppAutomationTest.pagesHelper.TestInit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

/**
 * 创建web'driver对象
 * @author Administrator
 *
 */
public  class Driver extends GetClassMethodName
{
	public static  AppiumDriver<WebElement>  driver=null;
	public static  DesiredCapabilities capabilities=null ;


	
	 public  void getDriver() 
	 {
		 initDriver();
//		 installApp();
	 }

	
 public  void initDriver() 
	{
	  capabilities = new DesiredCapabilities();
	 if (TestInit.IsAndroid) 
	 { 
//			创建adnroiddriver
				try {		
//					初始化并创建adnroid对象		
					Log.logInfo("开始创建androiddriver", GetClassMethodName());
					capabilities.setCapability("platformName", "Android");	
					capabilities.setCapability("deviceName",Config.AndroidDeviceName);
					capabilities.setCapability("appActivity",Config.appActivity);				
					capabilities.setCapability("appPackage",Config.appPackage );
					capabilities.setCapability("appWaitActivity",Config.appWaitActivity );
					capabilities.setCapability("appWaitPackage",Config.appWaitPackage);
					capabilities.setCapability("ignoreUnimportantViews",Config.ignoreUnimportantViews);	
					capabilities.setCapability("unicodeKeyboard", "true");//使用 Unicode 输入法  
					capabilities.setCapability("resetKeyboard", "true");  //重置输入法到原有状态  
					driver = new AndroidDriver(new URL(Config.URL),capabilities);
					Log.logInfo("创建androidDriver成功", GetClassMethodName());
					} 
				catch (MalformedURLException e) 
				{
					Log.logError("Driver-initDriver:创建driver读取配置文件错误，请检查！" +e.toString(),GetClassMethodName());
				}
//				判断当前应用是否安装
				Boolean isInstall=driver.isAppInstalled("cn.cooperative");
//				如果没安装则安装应用
					if (isInstall == false) 
					{
						try {
							Log.logInfo("开始安装应用",GetClassMethodName());
							driver.installApp(Config.AppFileLib+"xy.apk");
							
							Log.logInfo("应用安装成功",GetClassMethodName());
						
							} catch (Exception e) 
							{
								// TODO: handle exception
								Log.logError("无法安装应用，请检查安装文件路径！",GetClassMethodName());
							}
	
					}
					else {
						Log.logInfo("应用已存在，无需安装",GetClassMethodName());
					}

	 }
	 else 
	 {
			Log.logInfo("开始创建iosdriver", GetClassMethodName());
			capabilities.setCapability("platformName", "iOS");
			capabilities.setCapability("platformVersion", Config.platformVersion);						
			capabilities.setCapability("deviceName", Config.IOSDeviceName);
			capabilities.setCapability("calendarFormat", Config.calendarFormat);//只对模拟器起作用-用户设置模拟器日期显示格式		
			capabilities.setCapability("autoAcceptAlerts", true);//autoAcceptAlerts（非常实用）使用这个capability可以自动接受alert
			capabilities.setCapability("unicodeKeyboard", true);
			capabilities.setCapability("resetKeyboard", true);
//			//弹窗，比如定位弹窗、获取短信和联系人弹窗，读取照片弹窗等，默认值是false，如果测试app会出现alert建议

			File file=new File("./");
			String filePath=file.getAbsolutePath().toString();
			filePath=filePath+"File/apps/";
			filePath=filePath+Config.Iosapp;
			filePath=filePath.replace("/.", "/");
			Log.logInfo("ios测试安装包路径："+filePath,GetClassMethodName());
		    capabilities.setCapability("app",filePath);
		    try {
		    	driver = new IOSDriver(new URL(Config.URL),capabilities);
		    	  Log.logInfo("创建iosDriver成功", GetClassMethodName());
			} catch (Exception e) {
				  Log.logInfo("创建iosDriver失败，失败原因:"+e.toString(), GetClassMethodName());
				// TODO: handle exception
			}
		
		  
	 }
      

//	设置隐式等待
	
	driver.manage().timeouts().implicitlyWait(Config.implicitlyWaitTime, TimeUnit.SECONDS);

	}

}
