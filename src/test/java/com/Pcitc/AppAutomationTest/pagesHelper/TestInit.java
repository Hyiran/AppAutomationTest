package com.Pcitc.AppAutomationTest.pagesHelper;

import java.text.BreakIterator;
import java.util.Iterator;
import java.util.Map;

import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.base.TestBase;

import com.Pcitc.AppAutomationTest.utils.ExcelHandle;
import com.Pcitc.AppAutomationTest.utils.Log;
import com.Pcitc.AppAutomationTest.utils.TimeString;
import com.Pcitc.AppAutomationTest.utils.XMLParase;

import jxl.write.WriteException;
import sun.util.logging.resources.logging;

public class TestInit extends TestBase
{

//	存储测试平台
	public static boolean  IsAndroid=true;
//	存储测试环境
	public static boolean  IsTestEnvirectory=true;
	
	@Parameters({"plantForm","isTestEnvirectory"})
	@BeforeSuite(groups="AppPlatform",description="获得平台类型")
	public void  AppPlatform (String plantForm,String isTestEnvirectory) 
	{
//		获取环境变量
		 Map<String, String> map = System.getenv();
//	     获取环境
		 String envir= map.get("envir");
//		 获取平台
	     String plantform= map.get("plantform");		     
		System.out.println("------------平台："+plantform+"------------环境:"+envir);
		
//		初始化运行开始时间
		TestBase.startTime=TimeString.getyMDHMS();
		
//		获得测试平台
		 if (plantform.equals("Android")) 
		 {
//			 安卓环境
			 IsAndroid=true;
		 }
		 else {
			 IsAndroid=false;
		}
		 
//			获得测试环境
		 if (envir.equals("testen")) 
		 {
//			 测试环境
			 IsTestEnvirectory=true;
		 }
		 else {
			 IsTestEnvirectory=false;
		}
	
		Log.logInfo("当前是否为安卓测试："+IsAndroid+"当前是否为测试环境："+IsTestEnvirectory,GetClassMethodName());
		}
//	关闭appium服务 置空对象
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
			Log.logInfo("driver 强制释放",GetClassMethodName());
			throw new SkipException("Already Stop Test！");		  
		}
		else 
		{
			Log.logInfo("初始化成功-小盈办公-开始自动化测试",GetClassMethodName());
		}
	
//		afterClass(7, "测试开始");
		
	}
	
}
