package com.Pcitc.AppAutomationTest.pages;

import org.openqa.selenium.WebElement;

import com.Pcitc.AppAutomationTest.base.TestBase;
import com.Pcitc.AppAutomationTest.pagesHelper.TestInit;
import com.Pcitc.AppAutomationTest.utils.Log;


public class ESSP_GongShi extends TestBase 
{

	protected WebElement  LIgongshishenpiDE=null;
	protected WebElement  LIgongshishenpitiDE=null;
	protected WebElement  LIxingzhiDE=null;
	protected WebElement  LIleixingDE=null;
	protected WebElement  LIpishenDE=null;
	protected  void  ESSP_GongShiListPage()
	{
	if (TestInit.IsAndroid)
	{
		beforeMethod("ESSP_GongShiTest", "ESSP_GongShiTestPage");
		
		Log.logInfo("读取excel文件："+PageElmentExcle.getCellData(1, 1), classMethodeName);
		PageElmentExcleIndex=1;
//		点击差旅申请进入列表页面
LIgongshishenpitiDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
action.tap(LIgongshishenpitiDE, 1000);
Log.logInfo("已进入工时列表页", classMethodeName);
LIgongshishenpitiDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
LIxingzhiDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
LIleixingDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
LIpishenDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
//	Log.logInfo("2222", LIleixingDE.getText());
//	Log.logInfo("2222222", LIpishenDE.getText());
	}
}
}
