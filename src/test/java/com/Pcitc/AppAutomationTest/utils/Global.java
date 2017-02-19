package com.Pcitc.AppAutomationTest.utils;


import java.util.Map;

import com.Pcitc.AppAutomationTest.pagesHelper.Config;
/**
 * //XM全局数据
 * @author Administrator
 *
 */
public class Global extends GetClassMethodName
{
	
public static Map<String, String> global;
	static
	{
	XMLParase px=new XMLParase(Config.xmlLib+"global.xml");
	global=px.getChildrenInfoByElement(px.getElementObject("/*"));
	Log.logInfo("获取global节点成功", GetClassMethodName());
	}
}
