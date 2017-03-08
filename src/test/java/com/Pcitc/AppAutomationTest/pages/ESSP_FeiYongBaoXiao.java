package com.Pcitc.AppAutomationTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Pcitc.AppAutomationTest.base.TestBase;
import com.Pcitc.AppAutomationTest.pagesHelper.Location;
import com.Pcitc.AppAutomationTest.pagesHelper.TestInit;
import com.Pcitc.AppAutomationTest.utils.DataHandle;
import com.Pcitc.AppAutomationTest.utils.Log;

public class ESSP_FeiYongBaoXiao  extends TestBase {
	
	protected WebElement  LIfeiyongbaoxiaolinkDE= null;
	protected WebElement  LIfeiyongbaoxiaoDE= null;
	protected WebElement   LIpishenDE= null;
	protected WebElement  LIdaibanDE= null;
	protected WebElement  LIyibaanDE= null;
	protected  void  ESSP_FeiYongBaoXiaoListPage()
	{
	if (TestInit.IsAndroid)
	{
		Log.logInfo("读取excel文件："+PageElmentExcle.getCellData(1, 1), classMethodeName);
		
		changWaitTimeToVar(10);
		PageElmentExcleIndex=1;
//		点击差旅申请进入列表页面
		LIfeiyongbaoxiaolinkDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		action.tap(LIfeiyongbaoxiaolinkDE, 1000);
		changWaitTimeToVar(5);
		LIfeiyongbaoxiaoDE= getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		LIpishenDE= getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		LIdaibanDE= getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		LIyibaanDE= getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex=1;
	}
	else {
//		iOSFindAll path
			}
	}
	protected WebElement  INyibanbaoxiaoDE =null;
	protected WebElement  INzhushujuDE =null;
	protected WebElement  INdanjubianhaoDE =null;
	protected WebElement  INyuangongbianhaoDE =null;
	protected WebElement  INyuangongxingmingDE =null;
	protected WebElement  INsuoshubumenDE =null;
	protected WebElement  INsuoshuzuzhiDE =null;
	protected WebElement  INchongxiaojiekuanDE =null;
	protected WebElement  INfeiyongleixingDE =null;
	protected WebElement  INyibanxinxiDE =null;
	protected WebElement  INbaoxiaoriqiDE =null;
	protected WebElement  INbaoxiaoshiyouDE =null;
	protected WebElement  INchengbenhejiDE =null;
	protected WebElement  INchenbenfenpeiDE =null;
	protected WebElement  INgongsidaimaDE =null;
	
	
	protected WebElement  INyuangongbianhaoDA =null;
	protected WebElement  INyuangongxingmingDA =null;
	protected WebElement  INsuoshubumenDA =null;
	protected WebElement  INsuoshuzuzhiDA =null;
	protected WebElement  INchongxiaojiekuanDA =null;
	protected WebElement  INfeiyongleixingDA =null;
	protected WebElement  INbaoxiaoshiyouDA =null;
	protected WebElement  INchengbenhejiDA =null;
	protected WebElement  INgongsidaimaDA =null;
	
	int  i=0;
	protected  void  ESSP_FeiYongBaoXiaoDetails1(String no)
	{
		WebElement element=getElemntByYaml(Location.TextView_Ptext, true, true, no, "");
		action.tap(element, 800);
		Log.logInfo("已进入费用报销数据详情页", GetClassMethodName());
		INyibanbaoxiaoDE= getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INzhushujuDE= getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INdanjubianhaoDE= getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INyuangongbianhaoDE= getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INyuangongxingmingDE= getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INsuoshubumenDE= getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INsuoshuzuzhiDE= getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INchongxiaojiekuanDE= getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INfeiyongleixingDE= getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INyibanxinxiDE= getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INbaoxiaoriqiDE= getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INbaoxiaoshiyouDE= getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INchengbenhejiDE= getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INchenbenfenpeiDE= getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INgongsidaimaDE= getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	
	 PageElmentExcleIndex=4;
	 INyuangongbianhaoDA = getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	 INyuangongxingmingDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	 INsuoshubumenDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	 INsuoshuzuzhiDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	 INchongxiaojiekuanDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	 INfeiyongleixingDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	 PageElmentExcleIndex++;
	 PageElmentExcleIndex++;
	 INbaoxiaoshiyouDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	 INchengbenhejiDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	 PageElmentExcleIndex++;
	 INgongsidaimaDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	i=PageElmentExcleIndex;
	}
	
	protected WebElement INchengbenfeipei2DE =null;
	protected WebElement InshoujuxinxiDE =null;
	protected WebElement INshoujuleixingDE =null;
	protected WebElement INjineDE =null;
	protected WebElement INriqiDE =null;
	protected WebElement INxinxiDE =null;
	protected WebElement INshenpiyijianDE =null;
	protected WebElement INshenpirenDE =null;
	protected WebElement INzhuangtaiDE =null;
	protected WebElement INyijianDE =null;
	protected WebElement INshijianDE =null;

	
	protected WebElement INchengbenfeipei2DA=null;
	protected WebElement INshoujuleixingDA=null;
	protected WebElement INjineDA=null;
	protected WebElement INxinxiDA=null;
	protected  void  ESSP_FeiYongBaoXiaoDetails2()
	{
		By by=null;
		if (TestInit.IsAndroid) {
			 by =By.xpath(DataHandle.getBy(Location.Button_Ptext, "同意", ""));	
		}
		else {
//			ios
		}
		
	 action.swipe(by, "up", 2, false);
	 INchengbenfeipei2DE = getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	 InshoujuxinxiDE = getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;;
	 INshoujuleixingDE = getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;;
	 INjineDE = getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;;
	 INriqiDE = getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;;
	 INxinxiDE = getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;;
	 INshenpiyijianDE = getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;;
	 INshenpirenDE = getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;;
	 INzhuangtaiDE = getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;;
	 INyijianDE = getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;;
	 INshijianDE = getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;;
		
	 PageElmentExcleIndex=i;
	 INchengbenfeipei2DA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	 PageElmentExcleIndex=PageElmentExcleIndex+1;
	 INshoujuleixingDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	 INjineDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	 PageElmentExcleIndex=PageElmentExcleIndex+1;
	 INxinxiDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;	
	}
	
}
