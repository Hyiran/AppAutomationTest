package com.Pcitc.AppAutomationTest.testCases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.pages.CRM_KeHuGuanLi;
import com.Pcitc.AppAutomationTest.pagesHelper.PageFuntion;
import com.Pcitc.AppAutomationTest.pagesHelper.TestInit;
import com.Pcitc.AppAutomationTest.utils.KeyEvent;
import com.Pcitc.AppAutomationTest.utils.Log;

public class CRM_KeHuGuanLiTest  extends CRM_KeHuGuanLi
{

	@BeforeClass
	public void getPageElement()
	{ 	
	clasName=this.getClass().getSimpleName();
	beforeClass();		
	}
	@Test(priority='1',description="客户信息申报-列表页-测试")
	public void CRM_KeHuGuanLiTest_ListPage()
{
try {
	
	
	beforeMethod(clasName, "CRM_KeHuGuanLiTest_ListPage");
	String caseNo="客户信息申报-列表页-测试";
	Log.logInfo(caseNo, GetClassMethodName());	
	PageFuntion.logIn(getUserName("kehuguanli", "1"), getUserPassWord("kehuguanli", "1"));
	
//	进入列表页
	CRM_KeHuGuanLi_ListPage();
	int i=2;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), LIkehuguanlititleDE, Field, appiumDriver);
	i++;
	assertion.webElementIsNotNull(caseNo,LIkehuguanlitianjiaDE, "判断添加按钮是否存在", appiumDriver);
	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), LIkehuguanlidaibanDE,  Field, appiumDriver);
	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), LIkehuguanlichakanDE,  Field, appiumDriver);
	i++;
	
	action.pressKeyCode(KeyEvent.fanHui);
	PageFuntion.logOut();
	afterMethod(13,clasName);
	
	} 
catch (Exception e) {
PageFuntion.exceptionLogOutAndroid(endTime.toString());
	// TODO: handle exception
}		
}
	@Test(priority='2',description="客户信息申报-详情页-新增数据")
	public void CRM_KeHuGuanLiTest_Details() 
{
		try
{	
			PageElmentExcleIndex=1;
			String caseNo="客户信息申报-详情页-新增数据";
			Log.logInfo(caseNo, GetClassMethodName());	
			PageFuntion.logIn(getUserName("kehuguanli", "1"), getUserPassWord("kehuguanli", "1"));
			//			进入列表页
			CRM_KeHuGuanLi_ListPage();
		
//			进入详情页
			action.tap(LIkehuguanlitianjiaDE, 100);
			beforeMethod(clasName, "CRM_KeHuGuanLiTest_Details");
			CRM_KeHuGuanLi_DetailsPage1();
int i=1;


assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INkehuxinxishenbaoDE, Field, appiumDriver);i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INkehuxinxiDE,  Field, appiumDriver);i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INkehuquanchengDE,  Field, appiumDriver);i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INjituankehuDE,  Field, appiumDriver);i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INshangjidanweiDE,  Field, appiumDriver);i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INdakehujingliDE,  Field, appiumDriver);i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INsuozaibumenDE, Field, appiumDriver);i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INkehubeijingDE,  Field, appiumDriver);i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INguojiaDE,  Field, appiumDriver);i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INdiquDE,  Field, appiumDriver);i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INhangyeDE, Field, appiumDriver);i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INdizhiDE, Field, appiumDriver);i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INnianyingyeshouruDE, Field, appiumDriver);i++;

assertion.webElementIsNotNull(caseNo,INkehuquanchengDA, FieldData, appiumDriver);
assertion.webElementIsNotNull(caseNo,INjituankehuDA, FieldData, appiumDriver);
assertion.webElementIsNotNull(caseNo,INshangjidanweiDA, FieldData, appiumDriver);
assertion.webElementIsNotNull(caseNo,INdakehujingliDA, FieldData, appiumDriver);
assertion.webElementIsNotNull(caseNo,INsuozaibumenDA, FieldData, appiumDriver);
assertion.webElementIsNotNull(caseNo,INkehubeijingDA, FieldData, appiumDriver);
assertion.webElementIsNotNull(caseNo,INguojiaDA, FieldData, appiumDriver);
assertion.webElementIsNotNull(caseNo,INdiquDA, FieldData, appiumDriver);
assertion.webElementIsNotNull(caseNo,INhangyeDA, FieldData, appiumDriver);
assertion.webElementIsNotNull(caseNo,INdizhiDA, FieldData, appiumDriver);
assertion.webElementIsNotNull(caseNo,INnianyingyeshouruDA, FieldData, appiumDriver);


if (TestInit.IsAndroid) 
{
	action.sendKey(INkehuquanchengDA, "Android自动化测试");
}
else 
{
action.sendKey(INkehuquanchengDA, "ios自动化测试");
}
action.sendKey(INkehubeijingDA, "自动测试背景");

//action.tap(INguojiaDA, 800);
//PageFuntion.xialLaKuang_AndroidNoSure(caseNo, 3, PageElmentExcle, "国家", 1);

action.tap(INdiquDA, 800);
PageFuntion.xialLaKuang_AndroidNoSure(caseNo, 3, PageElmentExcle, "地区", 1);

action.tap(INhangyeDA, 800);
PageFuntion.xialLaKuang_AndroidNoSure(caseNo, 3, PageElmentExcle, "行业", 1);

action.sendKey(INdizhiDA, "北京东四十条南新仓12层");

action.sendKey(INnianyingyeshouruDA, "888");

CRM_KeHuGuanLi_DetailsPage2();
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INshichangleibieDE, Field, appiumDriver);i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INzhongyaoxingDE, Field, appiumDriver);i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INqianzaixuqiuDE, Field, appiumDriver);i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INlianxirenxingxiDE, Field, appiumDriver);i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INxingmingDE, Field, appiumDriver);i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INbumenDE, Field, appiumDriver);i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INzhiwuDE, Field, appiumDriver);i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INyoujianDE, Field, appiumDriver);i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INdianhuaDE, Field, appiumDriver);i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INshoujiDE, Field, appiumDriver);i++;

assertion.webElementIsNotNull(caseNo,INshichangleibieDA, FieldData, appiumDriver);
assertion.webElementIsNotNull(caseNo,INzhongyaoxingDA, FieldData, appiumDriver);
assertion.webElementIsNotNull(caseNo,INqianzaixuqiuDA, FieldData, appiumDriver);
assertion.webElementIsNotNull(caseNo,INxingmingDA, FieldData, appiumDriver);
assertion.webElementIsNotNull(caseNo,INbumenDA, FieldData, appiumDriver);
assertion.webElementIsNotNull(caseNo,INzhiwuDA, FieldData, appiumDriver);
assertion.webElementIsNotNull(caseNo,INyoujianDA, FieldData, appiumDriver);
assertion.webElementIsNotNull(caseNo,INdianhuaDA, FieldData, appiumDriver);
assertion.webElementIsNotNull(caseNo,INshoujiDA, FieldData, appiumDriver);

action.tap(INshichangleibieDA, 800);
PageFuntion.xialLaKuang_AndroidWithWanCheng("中石化市场");

action.tap(INzhongyaoxingDA, 800);
PageFuntion.xialLaKuang_AndroidWithWanCheng("大客户");

action.sendKey(INqianzaixuqiuDA, "自动化潜在需求666");

action.sendKey(INxingmingDA, "自动化姓名");
action.sendKey(INbumenDA, "自动化部门6");
action.sendKey(INzhiwuDA, "自动化职务");
action.sendKey(INyoujianDA, "邮件");
action.sendKey(INdianhuaDA, "电话");
action.sendKey(INshoujiDA, "手机");

PageFuntion.tiJiao_Android();
afterMethod(13,clasName);
afterClass(13,clasName);
} catch (Exception e) 
		{
	PageFuntion.exceptionLogOutAndroid(endTime.toString());
		}
}
}
