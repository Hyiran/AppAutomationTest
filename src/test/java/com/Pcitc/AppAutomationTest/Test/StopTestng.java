package com.Pcitc.AppAutomationTest.Test;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class StopTestng {
	/**
	 * @Title: runTest1
	 * @Description:Run the test and throw SkipException
	 * @return: void
	 */
	@Test
	public void runTest1() {
	        System.out.println("跳过执行");
	        throw new SkipException("skip test");
	}

	/**
	 * @Title: runTest1
	 * @Description:Run the test and throw Exception
	 * @return: void
	 */
	@Test
	public void runTest2() {
	       System.out.println("停止执行");
	        assert false:"stop test"; 
	}
	@Test
	public void runTest3() {
	        System.out.println("我可以执行吗");
	       
	}
}
