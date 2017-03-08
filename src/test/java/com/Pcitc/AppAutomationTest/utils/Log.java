package com.Pcitc.AppAutomationTest.utils;

import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.SkipException;

import com.Pcitc.AppAutomationTest.base.TestBase;

import com.Pcitc.AppAutomationTest.pagesHelper.PageFuntion;
import com.Pcitc.AppAutomationTest.pagesHelper.TestInit;

import bsh.commands.dir;


/**
 * 使用Log4j 输出日志
 * @author Administrator
 *
 */
public class Log   extends GetClassMethodName
{

	private static final Logger looger1=Logger.getLogger("TestLog");;
//	读取文件
	private static final String FilePath = "./config/log4j.properties";
	private static  boolean flag =false;
	private static synchronized void getPropertyFile()
		{
		File file=new File("./File/log/TestLog.log");
		try {
			if (!file.exists()) 
			{
				file.createNewFile();
				Log.logInfo("testlog.log 创建成功",GetClassMethodName() );
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		PropertyConfigurator.configure(new File(FilePath).getAbsolutePath());
		flag =true;
		}
	private static void getFlag()
		{
		if(flag==false)
			Log.getPropertyFile();
		}
/**
 * 正常日志输出
 * @param message
 * @param classMethodeName
 */
//	信息 用于信息打印
	public static void logInfo(Object message,String classMethodeName)
	{
	Log.getFlag();
	looger1.info("Infor:"+classMethodeName+message);
	}
	
	/**
	 * 警告 用于断言失败或者定位失败（有些定位不到没事如字段，有些则不行如按钮，根据情况调整）
	 * @param message 输出信息 
	 * @param classMethodeName 调用类的 类名 方法名
	 * @param snapShootName   截图文件名 用于超链接，断言类自动写入，定位类可为空；
	 */
	public static void logWarn(Object message,String classMethodeName,String snapShootName)
	{	
	Log.getFlag();
	looger1.info("Warn:"+classMethodeName+message);	
	TestBase.reportExcleExcelHandle.updateFile("./target/surefire-reports/html/测试报告.xls","");
	if (TestInit.IsAndroid) {
		TestBase.reportExcleExcelHandle.updateSheet("Android");
	}
	else {
		TestBase.reportExcleExcelHandle.updateSheet("Ios报告");
	}
	
//	第一列 信息列插入
	TestBase.reportExcleExcelHandle.addCellData(TestBase.reportExcleExcelRow, 0, (String) message);
//	第二列 状态列
	TestBase.reportExcleExcelHandle.addCellDataWithColor(TestBase.reportExcleExcelRow, 1, "警告", "", "YELLOW");
	if (snapShootName!="")
	{
//		第三列 截图列
//		System.out.println("log链接截图文件名"+snapShootName);
		TestBase.reportExcleExcelHandle.addCellDataWithLink(TestBase.reportExcleExcelRow, 2, snapShootName);
//		第四列 精确定位对象
		TestBase.reportExcleExcelHandle.addCellDataWithLink(TestBase.reportExcleExcelRow, 3, snapShootName+"Cut");
			
	}
	TestBase.reportExcleExcelHandle.afterExcle();
	TestBase.reportExcleExcelRow++;
	
	} 
	/**
	 * 错误 程序影响当前方法或者类的运行，在用例中catch使用。
	 * @param message 日志信息
	 * @param classMethodeName 调用类的方法 
	 */
//	
	public static void logError(Object message,String classMethodeName)
	{
	Log.getFlag();
	looger1.info("Error:"+classMethodeName+message);
	TestBase.reportExcleExcelHandle.updateFile("./target/surefire-reports/html/测试报告.xls", "");
	if (TestInit.IsAndroid) {
		TestBase.reportExcleExcelHandle.updateSheet("Android");
	}
	else {
		TestBase.reportExcleExcelHandle.updateSheet("Ios报告");
	}
//	第一列 信息列插入
	TestBase.reportExcleExcelHandle.addCellData(TestBase.reportExcleExcelRow, 0, (String) message);
//	第二列 状态列
	TestBase.reportExcleExcelHandle.addCellDataWithColor(TestBase.reportExcleExcelRow, 1, "错误", Color.heise, Color.hongse);
	
	TestBase.reportExcleExcelHandle.afterExcle();
	TestBase.reportExcleExcelRow++;
	
	PageFuntion.exceptionLogOutAndroid(message.toString());
		}
	
/**
 * 致命错误，影响后续执行,不可截图
 * @param message  日志信息
 * @param classMethodeName  调用者的方法及类名
 */
	public static void logDeadly(Object message,String classMethodeName)
	{
	Log.getFlag();
	looger1.info("Deadly:"+classMethodeName+message);
	TestBase.reportExcleExcelHandle.updateFile("./target/surefire-reports/html/测试报告.xls", "");
	if (TestInit.IsAndroid) {
		TestBase.reportExcleExcelHandle.updateSheet("Android");
	}
	else {
		TestBase.reportExcleExcelHandle.updateSheet("Ios报告");
	}
//	第一列 信息列插入
	TestBase.reportExcleExcelHandle.addCellData(TestBase.reportExcleExcelRow, 0, (String) message);
//	第二列 状态列
	TestBase.reportExcleExcelHandle.addCellDataWithColor(TestBase.reportExcleExcelRow, 1, "致命",Color.heise, Color.shenhongse);
	TestBase.reportExcleExcelHandle.afterExcle();
	TestBase.reportExcleExcelRow++;
	TestBase.StopRun=true;
	Log.logInfo("发生致命错误，稍后将停止全部测试", GetClassMethodName());
	TestBase.failTestCase++;
	TestBase.deadlyNo++;
	}
	
}
