package com.Pcitc.AppAutomationTest.Test;

import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.utils.GetClassMethodName;
import com.Pcitc.AppAutomationTest.utils.Log;

public class ClassNameTest3  extends GetClassMethodName
{
	@Test
	public void t3()
	{
		Log.logInfo("ClassNameTest3:", GetClassMethodName());
	}
}
