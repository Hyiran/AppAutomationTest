package com.Pcitc.AppAutomationTest.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.pages.DengLu;
import com.Pcitc.AppAutomationTest.pagesHelper.Location;
import com.Pcitc.AppAutomationTest.pagesHelper.PageFuntion;
import com.Pcitc.AppAutomationTest.pagesHelper.TestInit;
import com.Pcitc.AppAutomationTest.utils.Log;

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
		PageDataExcle=getExcle("登陆.xls", PageDataExcleSheet);
		FixDataExcle=getExcle( "登陆.xls", FixDataExcleSheet);
//		Log.logInfo("----"+FixDataExcle.getCellData(1,2));
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
	public void rightLogin()
		{
		String caseNo="登陆-正确用户名密码";
	Log.logInfo("222"+INusernameDA.getText());
	
	((MobileElement)_appiumDriver.findElement(By.xpath(""))).setValue("");  
	INusernameDA.click();
		INusernameDA.sendKeys("ssss");
//		Log.logInfo("测试用例："+caseNo); 
////		action.clearInputTextbox(INusernameDA);
//		action.sendKey(INusernameDA,FixDataExcle.getCellData(dataIndex, FixDataExcle.getCellData(1, 1)));
//		action.sendKey(INpassswordDA,FixDataExcle.getCellData(dataIndex, FixDataExcle.getCellData(1, 2)));
//		dataIndex++;
//		action.tap(INsubmitDE, 1000);
//		expetData=getElemnt("expetData", true, true, "荆影", "");
//		assertion.webElementIsNotNull(caseNo, expetData, "是否登陆成功", appiumDriver);
//		PageFuntion.logOut();
		}
	@Test(priority='2',description="用户名大写")
	public void BiguserLogin()
	{
		String caseNo="登陆-用户名大写";
		Log.logInfo("测试用例："+caseNo); 
		action.sendKey(INusernameDA,FixDataExcle.getCellData(dataIndex, FixDataExcle.getCellData(1, 1)));
		action.sendKey(INpassswordDA,FixDataExcle.getCellData(dataIndex, FixDataExcle.getCellData(1, 2)));
		dataIndex++;
		action.tap(INsubmitDE, 1000);
		expetData=null;
		expetData=getElemnt("expetData", true, true, "荆影", "");
		assertion.webElementIsNotNull(caseNo, expetData, "是否登陆成功", appiumDriver);
		PageFuntion.logOut();
	}
	@Test(priority='3',description="密码大写")
	public void wrongUserLogin()
	{
		String caseNo="登陆-密码大写";
		Log.logInfo("测试用例："+caseNo); 
		action.sendKey(INusernameDA,FixDataExcle.getCellData(dataIndex, FixDataExcle.getCellData(1, 1)));
		action.sendKey(INpassswordDA,FixDataExcle.getCellData(dataIndex, FixDataExcle.getCellData(1, 2)));
		dataIndex++;
		action.tap(INsubmitDE, 1000);
		expetData=null;
		parseYamlFile.needFound=false;
		expetData=getElemnt("expetData", true, true, "荆影", "");
		assertion.webElementIsNull(caseNo, expetData, "是否登陆成功", appiumDriver);
	
	}
	@Test(priority='4',description="用户名为空")
	public void wrongPasswordLogin()
	{
		String caseNo="登陆-用户名为空";
		Log.logInfo("测试用例："+caseNo); 
		action.clearInputTextbox(INusernameDA);
		action.sendKey(INpassswordDA,FixDataExcle.getCellData(dataIndex, FixDataExcle.getCellData(1, 2)));
		dataIndex++;
		action.tap(INsubmitDE, 1000);
		expetData=null;
		expetData=getElemnt("expetData", true, true, "荆影", "");
		assertion.webElementIsNull(caseNo, expetData, "是否登陆成功", appiumDriver);
	}
//	@Test(priority='1',description="密码为空")
	public void noPassWordLogin()
	{
		String caseNo="登陆-密码为空";
		Log.logInfo("测试用例："+caseNo); 
		action.sendKey(INusernameDA,FixDataExcle.getCellData(dataIndex, FixDataExcle.getCellData(1, 1)));
		dataIndex++;
		INpassswordDA.sendKeys("ssss");
		INusernameDA.sendKeys("ssss");
		action.clearInputTextbox(INpassswordDA);
		action.tap(INsubmitDE, 1000);
		expetData=null;
		expetData=getElemnt("expetData", true, true, "荆影", "");
		assertion.webElementIsNull(caseNo, expetData, "是否登陆成功", appiumDriver);
		parseYamlFile.needFound=true;
	}

}
