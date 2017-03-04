package com.Pcitc.AppAutomationTest.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.pages.PCITC_TestPage;
import com.Pcitc.AppAutomationTest.pagesHelper.Location;
import com.Pcitc.AppAutomationTest.pagesHelper.PageFuntion;
import com.Pcitc.AppAutomationTest.pagesHelper.TestInit;
import com.Pcitc.AppAutomationTest.utils.KeyEvent;
import com.Pcitc.AppAutomationTest.utils.Log;

import sun.util.logging.resources.logging;

public class PCITC_Test  extends PCITC_TestPage
{
	@BeforeClass
	public void getPageElement()
	{ 	
	clasName="ESSP_ChaiLvShenQing_Test";
	beforeClass();
	}

	@Test(priority='1',description="测试通过")
	public void ESSP_ChaiLvShenQing_ListPage() throws IOException
	{
	try {
		beforeMethod(clasName, "ESSP_ChaiLvShenQing_ListPage");
		caseNo="ceshi1";	
		Log.logInfo("执行用例数："+TestInit.totalTestCase,"");
		Log.logInfo("-------------------"+caseNo, classMethodeName);
		PageFuntion.logIn(getUserName("chailvshenqing", "1"), getUserPassWord("chailvshenqing", "1"));
		getOB();
		action.tap(element, 1000);
		action.pressKeyCode(KeyEvent.fanHui);
		PageFuntion.logOut();
		afterMethod(19,clasName);
		afterClass(19,clasName);
	} catch (Exception e) {
		PageFuntion.exceptionLogOutAndroid(endTime.toString());
	}	

}
//	@Test(priority='2',description="找不到对象")
	public void ESSP_ChaiLvShenQing_ListPage2() throws IOException
	{
	try {	
	beforeMethod(clasName, "ESSP_ChaiLvShenQing_ListPage");
	caseNo="ceshi2";	
	Log.logInfo("执行用例数："+TestInit.totalTestCase,"");
	Log.logInfo("-------------------"+caseNo, classMethodeName);
	WebElement element=getElemntByYaml(Location.TextView_Ptext, true, true, "ddd", "");
	afterMethod(19,clasName);
	
		} catch (Exception e) 
	{
			PageFuntion.exceptionLogOutAndroid(endTime.toString());
	}
	}
//	@Test(priority='3',description="断言失败")
	public void ESSP_ChaiLvShenQing_ListPage6() throws IOException
	{
	try {	
	beforeMethod(clasName, "ESSP_ChaiLvShenQing_ListPage");
	caseNo="ceshi3";	
	Log.logInfo("执行用例数："+TestInit.totalTestCase,"");
	Log.logInfo("-------------------"+caseNo, classMethodeName);
	WebElement element=getElemntByYaml(Location.TextView_Ptext, true, true, "账号",  "");
	assertion.verifyEquals("zhanghao", element, "duanyanshibai", appiumDriver);
	PageFuntion.logIn(getUserName("chailvshenqing", "1"), getUserPassWord("chailvshenqing", "1"));
	getOB();
	action.tap(element, 1000);
	action.pressKeyCode(KeyEvent.fanHui);
	PageFuntion.logOut();
	afterMethod(19,clasName);
	
		} catch (Exception e) 
	{
			PageFuntion.exceptionLogOutAndroid(endTime.toString());
	}
	}
//	@Test(priority='4',description="对象为空点击")
	public void ESSP_ChaiLvShenQing_ListPage3() throws IOException
	{
	try {
		beforeMethod(clasName, "ESSP_ChaiLvShenQing_ListPage");
		caseNo="ceshi4";
		Log.logInfo("执行用例数："+TestInit.totalTestCase,"");
		Log.logInfo("-------------------"+caseNo, classMethodeName);
		
		PageFuntion.logIn(getUserName("chailvshenqing", "1"), getUserPassWord("chailvshenqing", "1"));
		getOB();
		action.tap(element, 1000);
		WebElement element2=null;	
		action.tap(element2, 1000);
		afterMethod(19,clasName);
		} catch (Exception e) 
	{
			PageFuntion.exceptionLogOutAndroid(endTime.toString());
	}
	}
	
//	@Test(priority='5',description="方法内捕获异常")
	public void ESSP_ChaiLvShenQing_ListPage4() throws IOException
	{
	try {
		beforeMethod(clasName, "ESSP_ChaiLvShenQing_ListPage");
		caseNo="cesh5";	
		Log.logInfo("执行用例数："+TestInit.totalTestCase,"");
		Log.logInfo("-------------------"+caseNo, classMethodeName);
		PageFuntion.logIn(getUserName("chailvshenqing", "1"), getUserPassWord("chailvshenqing", "1"));
		getOB();
		action.tap(element, 1000);
		String [] a={"2","2"};
		System.out.print(a[3]);
		action.pressKeyCode(KeyEvent.fanHui);
		PageFuntion.logOut();
		afterMethod(19,clasName);
		afterClass(19,clasName);
		} catch (Exception e) 
	{
			PageFuntion.exceptionLogOutAndroid(endTime.toString());
	}
	}
//	@Test(priority='6',description="插入执行成功")
	public void ESSP_ChaiLvShenQing_ListPage9() throws IOException
	{
		beforeMethod(clasName, "ESSP_ChaiLvShenQing_ListPage");
		Log.logInfo("执行用例数："+TestInit.totalTestCase,"");
		afterMethod(19,clasName);
		
	}
	
}		
