package com.Pcitc.AppAutomationTest.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.pages.DengLu;
import com.Pcitc.AppAutomationTest.pagesHelper.Config;
import com.Pcitc.AppAutomationTest.pagesHelper.Location;
import com.Pcitc.AppAutomationTest.pagesHelper.PageFuntion;
import com.Pcitc.AppAutomationTest.pagesHelper.TestInit;
import com.Pcitc.AppAutomationTest.utils.Log;
import com.Pcitc.AppAutomationTest.utils.OperateImage;

import io.appium.java_client.MobileElement;


public class DengLuTest extends  DengLu
{
	public void DengLuTest() 
	{
		if (TestInit.IsAndroid)
		{
			getBeforeElement("Android登陆");
		}
		else {
			getBeforeElement("Ios登陆");
			}
	
		Log.logInfo("yaml文件已加载",GetClassMethodName());
//		PageDataExcle=getExcle("登陆", "默认数据");
//		FixDataExcle=getExcle( "登陆", "选择数据");

	}
	@BeforeClass
	public void getPageElement()
	{ 	
		DengLuTest();
		findElelment();
	}
	
	private WebElement expetData =null;
	int dataIndex=1;
	@Test(priority='1',description="正确用户名密码")
	public void logIn_rightLogin() throws IOException
		{
	     

		String caseNo="登陆-正确用户名密码";
		Log.logInfo("测试用例："+caseNo,GetClassMethodName()); 
		assertion.verifyEquals(caseNo,"ww", INusernameDA, "dasdasd", appiumDriver);
//		action.sendKey(INusernameDA,FixDataExcle.getCellData(dataIndex, FixDataExcle.getCellData(1, 1)));
//		action.sendKey(INpassswordDA,FixDataExcle.getCellData(dataIndex, FixDataExcle.getCellData(1, 2)));
		dataIndex++;
		action.tap(INsubmitDE, 1000);
//		expetData=getElemnt("expetData", true, true, "荆影", "");
		assertion.webElementIsNotNull(caseNo,expetData, "是否登陆成功", appiumDriver);
		PageFuntion.logOut();
		}
	@Test(priority='2',description="用户名大写")
	public void logIn_Biguser()
	{
		String  caseNo="登陆-用户名大写";
		Log.logInfo("测试用例："+caseNo,GetClassMethodName()); 
//		action.sendKey(INusernameDA,FixDataExcle.getCellData(dataIndex, FixDataExcle.getCellData(1, 1)));
//		action.sendKey(INpassswordDA,FixDataExcle.getCellData(dataIndex, FixDataExcle.getCellData(1, 2)));
		dataIndex++;
		action.tap(INsubmitDE, 1000);
		expetData=null;
//		expetData=getElemnt("expetData", true, true, "荆影", "");
		assertion.webElementIsNotNull( caseNo,expetData, "是否登陆成功", appiumDriver);
		PageFuntion.logOut();
	}
	@Test(priority='3',description="密码大写")
	public void logIn_PassWordBig()
	{
		String caseNo="登陆-密码大写";
		Log.logInfo("测试用例："+caseNo,GetClassMethodName()); 
//		action.sendKey(INusernameDA,FixDataExcle.getCellData(dataIndex, FixDataExcle.getCellData(1, 1)));
//		action.sendKey(INpassswordDA,FixDataExcle.getCellData(dataIndex, FixDataExcle.getCellData(1, 2)));
		dataIndex++;
		action.tap(INsubmitDE, 1000);
		expetData=null;
		parseYamlFile.needFound=false;
//		expetData=getElemnt("expetData", true, true, "荆影", "");
		assertion.webElementIsNull(caseNo, expetData, "是否登陆成功", appiumDriver);
	
	}
	@Test(priority='4',description="用户名为空")
	public void logIn_userNameNull()
	{
		String caseNo="登陆-用户名为空";
		Log.logInfo("测试用例："+caseNo,GetClassMethodName()); 
		action.clearInputTextbox(INusernameDA);
//		action.sendKey(INpassswordDA,FixDataExcle.getCellData(dataIndex, FixDataExcle.getCellData(1, 2)));
		dataIndex++;
		action.tap(INsubmitDE, 1000);
		expetData=null;
//		expetData=getElemnt("expetData", true, true, "荆影", "");
		assertion.webElementIsNull( caseNo,expetData, "是否登陆成功", appiumDriver);
	}
	@Test(priority='5',description="密码为空")
	public void noPassWordLogin()
	{
		String 	 caseNo="登陆-密码为空";
		Log.logInfo("测试用例："+caseNo,GetClassMethodName()); 
//		action.sendKey(INusernameDA,FixDataExcle.getCellData(dataIndex, FixDataExcle.getCellData(1, 1)));
		dataIndex++;
		action.sendKey(INpassswordDA, "  ");
		action.tap(INsubmitDE, 1000);
		expetData=null;
//		expetData=getElemnt("expetData", true, true, "荆影", "");
		assertion.webElementIsNull( caseNo,expetData, "是否登陆成功", appiumDriver);
		parseYamlFile.needFound=true;
	}

}
