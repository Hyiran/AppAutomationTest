package com.Pcitc.AppAutomationTest.utils;

import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.Pcitc.AppAutomationTest.base.TestBase;

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
		PropertyConfigurator.configure(new File(FilePath).getAbsolutePath());
		flag =true;
		}
	private static void getFlag()
		{
		if(flag==false)
			Log.getPropertyFile();
		}

//	信息 用于信息打印
	public static void logInfo(Object message,String classMethodeName)
	{
	Log.getFlag();
	looger1.info("Infor:"+classMethodeName+message);
	}
	/**
	 * 执行断言类调用
	 * @param message 输出信息 
	 * @param classMethodeName 调用类的 类名 方法名
	 * @param snapShootName  截图文件名 用于超链接
	 */
//	警告 用于断言失败时候调用
	public static void logWarn(Object message,String classMethodeName,String snapShootName)
	{	
	Log.getFlag();
	looger1.info("Warn:"+classMethodeName+message);	
//	第一列 信息列插入
	TestBase.reportExcleExcelHandle.addCellData(TestBase.reportExcleExcelRow, 0, (String) message);
//	第二列 状态列
	TestBase.reportExcleExcelHandle.addCellDataWithColor(TestBase.reportExcleExcelRow, 1, "警告", "", "YELLOW");
	if (snapShootName!="")
	{
//		第三列 截图列
		TestBase.reportExcleExcelHandle.addCellDataWithLink(TestBase.reportExcleExcelRow, 2, snapShootName);
//		第四列 精确定位对象
		TestBase.reportExcleExcelHandle.addCellDataWithLink(TestBase.reportExcleExcelRow, 3, snapShootName+"Cut");
	}
	TestBase.reportExcleExcelRow++;
	} 
//	错误 用于 程序异常捕获到到异常
	public static void logError(Object message,String classMethodeName)
	{
	Log.getFlag();
	looger1.info("Error:"+classMethodeName+message);
//	第一列 信息列插入
	TestBase.reportExcleExcelHandle.addCellData(TestBase.reportExcleExcelRow, 0, (String) message);
//	第二列 状态列
	TestBase.reportExcleExcelHandle.addCellDataWithColor(TestBase.reportExcleExcelRow, 1, "错误", "", "RED");
	TestBase.reportExcleExcelRow++;
	}
	

}
