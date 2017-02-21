package com.Pcitc.AppAutomationTest.Test;

import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.utils.GetClassMethodName;
import com.Pcitc.AppAutomationTest.utils.Log;


public class ClassNameTest  extends GetClassMethodName
{
	@Test(description="测试获取当前类及方法")
	public void t1()
	{	
	
		Log.logInfo("执行类的类名及方法:", GetClassMethodName());
		
		Log.logInfo("调用类的类名及方法:", GetDiaoYongClassMethodName());
	}
}
