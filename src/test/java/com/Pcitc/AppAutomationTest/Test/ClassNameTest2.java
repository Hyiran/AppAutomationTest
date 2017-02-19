package com.Pcitc.AppAutomationTest.Test;

import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.utils.Log;

public class ClassNameTest2  extends ClassNameTest
{
	@Test(description="测试获取当前类及方法")
	public void t2()
	{
		super.t1();
		ClassNameTest3 t3=new ClassNameTest3();
	
 		Log.logInfo("ClassNameTest2", GetClassMethodName());
 		
 		t3.t3();
	}
//	结论：
//	方法名会调用格子类中的
//	类名则调用子类的名字 
	
}
