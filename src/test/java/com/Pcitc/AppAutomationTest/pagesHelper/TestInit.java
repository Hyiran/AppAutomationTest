package com.Pcitc.AppAutomationTest.pagesHelper;

import java.text.BreakIterator;

import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.base.TestBase;
import com.Pcitc.AppAutomationTest.pages.Color;
import com.Pcitc.AppAutomationTest.utils.ExcelHandle;
import com.Pcitc.AppAutomationTest.utils.Log;
import com.Pcitc.AppAutomationTest.utils.TimeString;
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
	
	@Parameters({"plantForm","isTestEnvirectory"})
	@BeforeSuite(groups="AppPlatform",description="获得平台类型")
	
public void  AppPlatform (String plantForm,String isTestEnvirectory) 
		{
		
		System.out.print("------------"+plantForm);
//		获得运行开始时间
		TestBase.startTime=TimeString.getyMDHMS();
//		获得测试环境
//		获得测试平台
		 if (plantForm.equals("Android")) 
		 {
			 IsAndroid=true;
		 }
		 else {
			 IsAndroid=false;
		}
		 if (plantForm.equals("true")) 
		 {
			 IsTestEnvirectory=true;
		 }
		 else {
			 IsTestEnvirectory=false;
		}
	
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
	if (isGenReport!=true) {
		appiumDriver.quit();
		appiumDriver=null;
	}
		
		Log.logInfo("已释放appiumDriver服务",GetClassMethodName());
		Log.logInfo("已关闭appium服务",GetClassMethodName());
	}
//	初始化action driver等对象
	@BeforeTest
	public void getAppiumDriver()
	{
		getDriver();
		Log.logInfo("测试初始化完毕",GetClassMethodName());
	}
//	生成报告
	@AfterTest
	public void closeDriver()
	{
		if (isGenReport!=true) 
		{
			GenExcleDetailsReport();
		}
		
	}
	@Test(description="是否达到执行条件")
	public void autoTest()
	{
		if (StopRun) 
		{
			Log.logDeadly("初始化失败导致自动化测试中断,原因： "+ErrorList, GetClassMethodName());
			appiumDriver.quit();
			appiumDriver=null;
			Log.logInfo("driver 释放成功",GetClassMethodName());
			throw new SkipException("Already Stop Test！");		  
		}
		else 
		{
			Log.logInfo("初始化成功-小盈办公-开始自动化测试",GetClassMethodName());
		}
	

		
	}
	
}
