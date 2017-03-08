package com.Pcitc.AppAutomationTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Pcitc.AppAutomationTest.base.TestBase;
import com.Pcitc.AppAutomationTest.pagesHelper.Location;
import com.Pcitc.AppAutomationTest.pagesHelper.TestInit;
import com.Pcitc.AppAutomationTest.utils.DataHandle;
import com.Pcitc.AppAutomationTest.utils.ExcelReader;
import com.Pcitc.AppAutomationTest.utils.Log;

import io.appium.java_client.pagefactory.iOSFindAll;


public class ESSP_ChaiLvShenQing  extends TestBase
{
	
	protected WebElement  LIchailvshenqingDE= null;
	protected WebElement  LIxinjianshenqingDE= null;
	protected WebElement   LIshenqingqingdanDE= null;
	protected WebElement  LIchailvshenqinglinkDE= null;
	protected  void  ESSP_ChaiLvShenQingListPage()
	{
	if (TestInit.IsAndroid)
	{
		Log.logInfo("读取excel文件："+PageElmentExcle.getCellData(1, 1), classMethodeName);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PageElmentExcleIndex=1;
//		点击差旅申请进入列表页面
		LIchailvshenqinglinkDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		action.tap(LIchailvshenqinglinkDE, 1000);
		LIchailvshenqingDE= getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		LIxinjianshenqingDE= getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		LIshenqingqingdanDE= getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex=1;
	}
	else {
//		iOSFindAll path
			}
	}
	
	protected WebElement INxijianchailvshenqingDE =null;
	protected WebElement INzhushujuDE =null;
	protected WebElement INyuangongbianhaoDE =null;
	protected WebElement INyuangongxingmingDE =null;
	protected WebElement INfeiyongleixingDE =null;
	protected WebElement INchailvleixingDE =null;
	protected WebElement INshifoujiekuanDE =null;
	protected WebElement INkaishishijianDE =null;
	protected WebElement INjieshushijianDE =null;
	protected WebElement INchuchaidiquDE =null;
	protected WebElement INyujifeiyongDE =null;
	protected WebElement INchuchaishiyouDE =null;
	protected WebElement INchengbenfenpeiDE =null;
	protected WebElement INchenbenleixingDE =null;
	protected WebElement INfenpeibianhaoDE =null;
	
	
	protected WebElement INyuangongbianhaoDA =null; 
	protected WebElement INyuangongxingmingDA =null;
	protected WebElement INfeiyongleixingDA =null;
	protected WebElement INchailvleixingDA =null;
	protected WebElement INshifoujiekuanDA =null;
	protected WebElement INkaishishijianDA =null;
	protected WebElement INjieshushijianDA =null;
	protected WebElement INchuchaidiquDA =null;
	protected WebElement INqingshuruchengshiDA =null;
	protected WebElement INyujifeiyongDA =null;
	protected WebElement INchuchaishiyouDA =null;
	protected WebElement INchenbenleixingDA =null;
	protected WebElement INfenpeibianhaoDA =null;
	private int pageIndex=0;
	protected  void  ESSP_ChaiLvShenQingDetails1()
	{
	if (TestInit.IsAndroid)
	{
//		点击新建申请
		LIxinjianshenqingDE= getElemntByYaml(Location.TextView_Ptext, true, true, "新建申请", "");
		action.tap(LIxinjianshenqingDE, 1000);
		PageElmentExcleIndex=1;
	  INxijianchailvshenqingDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	  INzhushujuDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	  INyuangongbianhaoDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	  INyuangongxingmingDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	  INfeiyongleixingDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	  INchailvleixingDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	  INshifoujiekuanDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	  INkaishishijianDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	  INjieshushijianDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	  INchuchaidiquDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	  INyujifeiyongDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	  INchuchaishiyouDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	  INchengbenfenpeiDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	  INchenbenleixingDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	  INfenpeibianhaoDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	  PageElmentExcleIndex=1;
		
	  INyuangongbianhaoDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	  INyuangongxingmingDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	  INfeiyongleixingDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	  INchailvleixingDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	  INshifoujiekuanDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	  INkaishishijianDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	  INjieshushijianDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	  INchuchaidiquDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	  INqingshuruchengshiDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	  INyujifeiyongDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	  INchuchaishiyouDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	  INchenbenleixingDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	  INfenpeibianhaoDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	  pageIndex=PageElmentExcleIndex;
	}
	else {
//		iOSFindAll path
		}
	}
	
	protected WebElement INzhichujihuaDE =null;
	protected WebElement INshoujuleixingDE =null;
	protected WebElement INriqiDE =null;
	protected WebElement INhuobiDE =null;
	protected WebElement INjineDE =null;
	protected WebElement INxinxiDE =null;
	protected WebElement INhuilvDE =null;
	protected WebElement INbenweibiDE =null;
	protected WebElement INtianjiaDE =null;
	protected WebElement INfujiamudidiDE =null;
	protected WebElement INwenxintishiDE =null;
	
	
	protected WebElement INshoujuleixingDA =null;
	protected WebElement INriqiDA =null;
	protected WebElement INhuobiDA =null;
	protected WebElement INjineDA =null;
	protected WebElement INxinxiDA =null;
	protected WebElement INhuilvDA =null;
	protected WebElement INbenweibiDA =null;
	protected  void  ESSP_ChaiLvShenQingDetails2()
	{
	if (TestInit.IsAndroid)
	{
		By by=By.xpath(DataHandle.getBy(Location.TextView_Ptext, "附加目的地", ""));
	action.swipe(by, "up", 4,false);
	INzhichujihuaDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	INshoujuleixingDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	INriqiDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	INhuobiDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	INjineDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	INxinxiDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	INhuilvDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	INbenweibiDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	INtianjiaDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	INfujiamudidiDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	INwenxintishiDE =getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	PageElmentExcleIndex=pageIndex;
	INshoujuleixingDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	INriqiDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	INhuobiDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	INjineDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	INxinxiDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	INhuilvDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	INbenweibiDA =getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	}
	}

}

