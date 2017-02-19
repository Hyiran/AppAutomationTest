package com.Pcitc.AppAutomationTest.pagesHelper;


import java.security.PublicKey;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.base.TestBase;
import com.Pcitc.AppAutomationTest.utils.GetClassMethodName;
import com.Pcitc.AppAutomationTest.utils.Log;
import com.Pcitc.AppAutomationTest.utils.XMLParase;

/**
 * 解析各页面对象定位文件 及等待时间 
 * @author Administrator
 */
public class Config  extends GetClassMethodName
{	
//	public
	public static  XMLParase  xm = null;	
	public static String configFilePath;
	public static String xmlLib;
	public static String excleLib;
	public static String yamlLib;
	
	public static String platformName;
	public static String URL;
	public static String Browser;
	public static int implicitlyWaitTime ;//隐式等待时间--10秒
	public static int ElementWaitTime;//显示等待时间--20秒
	public static String ignoreUnimportantViews;
	public static String newCommandTimeout;
	public static String AppPath;
	
//	ios
	public static String platformVersion;
	public static String IOSDeviceName;
	public static String bundleld;
	public static String calendarFormat;
	public static String locationServicesEnabled;
	public static String autoAcceptAlerts;
	public static String nativeInstrumentsLib;
	public static String Iosapp;


//android
	public static String AndroidDeviceName;
	public static String appActivity;
	public static String appPackage;
	public static String appWaitActivity;
	public static String appWaitPackage;
	public static String  Androidapp;
	

//	解析配置文件中的环境及用户名 密码

	static 
		{
		 configFilePath="./config/";
		 xm =new XMLParase(configFilePath+"config.xml");
//		Public
		
		xmlLib="./File/dataXmls/";
		excleLib="./File/dataExcles/";
		yamlLib="./File/yamls/";
		
		AppPath=xm.getElementText("/*/AppPath");
		Browser=xm.getElementText("/*/Browser");
		URL=xm.getElementText("/*/URL");
		ElementWaitTime=Integer.valueOf(xm.getElementText("/*/ElementWaitTime"));
		implicitlyWaitTime=Integer.valueOf(xm.getElementText("/*/implicitlyWaitTime"));
		newCommandTimeout="/*/newCommandTimeout";
		
		
//		Android
		AndroidDeviceName=xm.getElementText("/*/AndroidDeviceName");
		appActivity=xm.getElementText("/*/appActivity");
		appWaitActivity=xm.getElementText("/*/appWaitActivity");
		appPackage=xm.getElementText("/*/appPackage");
		appWaitPackage=xm.getElementText("/*/appWaitPackage");
		ignoreUnimportantViews=xm.getElementText("/*/ignoreUnimportantViews");
		Androidapp=xm.getElementText("/*/Androidapp");
		
//		IOS
		IOSDeviceName=xm.getElementText("/*/IOSDeviceName");
		calendarFormat=xm.getElementText("/*/calendarFormat");
		autoAcceptAlerts=xm.getElementText("/*/autoAcceptAlerts");
		platformVersion=xm.getElementText("/*/platformVersion");
		Iosapp=xm.getElementText("/*/Iosapp");
	


		}

	public  static String getyamlpath(String className)
	 {
		 String ElmentFilePath=String.format("./ConfigFile/%s"+".yaml",className);
		 return ElmentFilePath;
	 }

	
}