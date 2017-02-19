package com.Pcitc.AppAutomationTest.Test;

import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.utils.GetClassMethodName;
import com.Pcitc.AppAutomationTest.utils.Log;
import com.sun.org.glassfish.gmbal.Description;

public class ClassNameTest  extends GetClassMethodName
{
	@Test(description="测试获取当前类及方法")
	public void t1()
	{	
		System.out.println("classname:"+clasName);
		System.out.println("methodname:"+MethodeName);
		System.out.println("classMethodName:"+classMethodeName);
		Log.logInfo("ClassNameTest:", GetClassMethodName());
	}
}
