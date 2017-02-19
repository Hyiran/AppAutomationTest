package com.Pcitc.AppAutomationTest.utils;

import java.io.File;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


/**
 * 使用Log4j 输出日志
 * @author Administrator
 *
 */
public class Log  
{
	
	private static final Logger looger1=Logger.getLogger("TestLog");;
//	读取文件
	private static final String FilePath = "./config/log4j.properties";
//	private static  boolean flag =false;
	
	
	private static synchronized void getPropertyFile()
		{
		
		PropertyConfigurator.configure(new File(FilePath).getAbsolutePath());
//		flag =true;
		}
	private static void getFlag()
		{
//		if(flag==false)
			Log.getPropertyFile();
		}
	public static void logInfo(Object message)
		{
		Log.getFlag();
		
		looger1.info("Infor:"+message);
		}
	public static void logInfo(Object message,String classMethodeName)
	{
	Log.getFlag();
	looger1.info("Infor:"+classMethodeName+message);
	}
	
	
	public static void logError(String message)
		{
		Log.getFlag();
		looger1.error("Error:"+message);
		}
	public static void logError(Object message,String classMethodeName)
	{
	Log.getFlag();
	looger1.info("Error:"+classMethodeName+message);
	}
	
	public static void logWarn(String message)
		{
		Log.getFlag();
		looger1.warn("Warm:"+message);
		}
	public static void logWarn(Object message,String classMethodeName)
	{
	Log.getFlag();
	looger1.info("Warn:"+classMethodeName+message);
	}
}
