package com.Pcitc.AppAutomationTest.utils;


import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ErrorLog {
	private static final Logger looger=Logger.getLogger("ErrorLog");
//	读取文件
	private static final String filePath = "./config/log4jError.properties";
//	private static  boolean flag =false;
	
	private static synchronized void getPropertyFile()
		{
		PropertyConfigurator.configure(new File(filePath).getAbsolutePath());
//		flag =true;
		}
	private static void getFlag()
		{
//		if(flag==false)
			ErrorLog.getPropertyFile();
		}

	public static void logError(String message)
		{
		ErrorLog.getFlag();
		looger.error("Error:"+message);
		}
	public static void logError(String message,String GetClassMethodName)
	{
	ErrorLog.getFlag();
	looger.error("Error:"+GetClassMethodName+"-"+message);
	}

}
