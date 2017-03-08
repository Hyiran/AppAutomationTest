package com.Pcitc.AppAutomationTest.testCases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.pages.PCITC_TestPage;
import com.Pcitc.AppAutomationTest.pagesHelper.Location;
import com.Pcitc.AppAutomationTest.pagesHelper.PageFuntion;
import com.Pcitc.AppAutomationTest.pagesHelper.TestInit;
import com.Pcitc.AppAutomationTest.utils.KeyEvent;
import com.Pcitc.AppAutomationTest.utils.Log;

public class PCITC_Test2 extends PCITC_TestPage
{
	@BeforeClass
	public void getPageElement()
	{ 	
	clasName="ESSP_ChaiLvShenQing_Test";
	beforeClass();
	}

	@Test(priority='2',description="断言失败")
	public void ESSP_ChaiLvShenQing_ListPage6() throws IOException
	{
	try {	
	beforeMethod(clasName, "ESSP_ChaiLvShenQing_ListPage");
	String caseNo="ceshi3";	
	Log.logInfo("执行用例数："+TestInit.totalTestCase,"");
	Log.logInfo("-------------------"+caseNo, classMethodeName);
	WebElement element=getElemntByYaml(Location.TextView_Ptext, true, true, "账号",  "");
	assertion.verifyEquals(caseNo,"zhanghao", element, "duanyanshibai", appiumDriver);
	PageFuntion.logIn(getUserName("chailvshenqing", "1"), getUserPassWord("chailvshenqing", "1"));
	getOB();
	action.tap(element, 1000);
	action.pressKeyCode(KeyEvent.fanHui);
	PageFuntion.logOut();
	afterMethod(20,clasName);
	afterClass(20,clasName);
		} catch (Exception e) 
	{
			PageFuntion.exceptionLogOutAndroid(endTime.toString());
	}
	}

}
