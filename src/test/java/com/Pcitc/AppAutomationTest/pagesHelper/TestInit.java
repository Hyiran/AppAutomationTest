package com.Pcitc.AppAutomationTest.pagesHelper;

import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.base.TestBase;
import com.Pcitc.AppAutomationTest.utils.ExcelHandle;
import com.Pcitc.AppAutomationTest.utils.Log;
import com.Pcitc.AppAutomationTest.utils.XMLParase;

import jxl.write.WriteException;
import sun.util.logging.resources.logging;

public class TestInit extends TestBase
{
//	设置图片路径
	private   final String  PictureLib="./FileLibrary/Picture/"; 

//	获得移动端平台

	
	public static boolean  IsAndroid=true;
	public static boolean  IsTestEnvirectory=true;
	@Parameters({"isAndroid","isTestEnvirectory"})

	
	@BeforeSuite(groups="AppPlatform",description="获得平台类型")
	public void  AppPlatform (Boolean isAndroid,Boolean isTestEnvirectory) 
		{
	
//		获得测试环境
//		获得测试平台
		IsAndroid=isAndroid;
		IsTestEnvirectory=isTestEnvirectory;
		Log.logInfo("当前是否为安卓测试："+IsAndroid+"当前是否为测试环境："+IsTestEnvirectory,GetClassMethodName());
	

		
//		获得screen 对象
//		getScreen();

//		启动appium 
		try {
//			点击appium 图标

//			screen.wait(PictureLib+"appium2.png",8);

//			screen.click();
//			Log.logInfo("appium 图标已被点击");
	
//			TestBase.	screen.wait(PictureLib+"begin.png",5);
//			TestBase.	screen.click();
//			Thread.sleep(3000);
			Log.logInfo("已启动appium服务",GetClassMethodName());
		} catch (Exception e) {
			
		Log.logError("启动appiun服务异常",GetClassMethodName());
		}
		
		}
//	关闭appium服务
	@AfterSuite
	public void closeAppiumServer()
	{

		TestBase.reportExcleExcelHandle.afterExcle();	
		Log.logInfo("测试报告已生成",GetClassMethodName());
		Log.logInfo("已关闭appium服务",GetClassMethodName());
	}
//	初始化action driver等对象
	@BeforeTest
	public void getAppiumDriver()
	{
		getDriver();
		Log.logInfo("测试初始化成功",GetClassMethodName());
	}
//	关闭driver
	@AfterTest
	public void closeDriver()
	{
		appiumDriver.quit();
		appiumDriver=null;
		Log.logInfo("driver 释放成功",GetClassMethodName());
	}
	@Test(description="开始执行测试")
	public void autoTest()
	{
		Log.logInfo("小盈办公-开始自动化测试",GetClassMethodName());

		
	}
	
}
