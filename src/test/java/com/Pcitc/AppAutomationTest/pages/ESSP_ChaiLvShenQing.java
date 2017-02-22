package com.Pcitc.AppAutomationTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Pcitc.AppAutomationTest.base.TestBase;
import com.Pcitc.AppAutomationTest.pagesHelper.Location;
import com.Pcitc.AppAutomationTest.pagesHelper.TestInit;
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
		Log.logInfo("------"+PageElmentExcle.getCellData(1, AndroidTitleLocatString), classMethodeName);
		
		
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
	protected  void  ESSP_ChaiLvShenQingDetails1()
	{
//	if (TestInit.IsAndroid)
//	{
//		点击新建申请
//		LIxinjianshenqingDE= getElemnt(Location.id, true, true, "cn.cooperative:id/textTravelApplyNew", "");
//		action.tap(LIxinjianshenqingDE, 1000);
//		int index=1;
//	  INxijianchailvshenqingDE =getElemnt(PageElmentExcle.getCellData(index, fiedColName), true, false, "","");index++;
//	  INzhushujuDE =getElemnt(PageElmentExcle.getCellData(index, fiedColName), true, false, "","");index++;
//	  INyuangongbianhaoDE =getElemnt(PageElmentExcle.getCellData(index, fiedColName), true, false, "","");index++;
//	  INyuangongxingmingDE =getElemnt(PageElmentExcle.getCellData(index, fiedColName), true, false, "","");index++;
//	  INfeiyongleixingDE =getElemnt(PageElmentExcle.getCellData(index, fiedColName), true, false, "","");index++;
//	  INchailvleixingDE =getElemnt(PageElmentExcle.getCellData(index, fiedColName), true, false, "","");index++;
//	  INshifoujiekuanDE =getElemnt(PageElmentExcle.getCellData(index, fiedColName), true, false, "","");index++;
//	  INkaishishijianDE =getElemnt(PageElmentExcle.getCellData(index, fiedColName), true, false, "","");index++;
//	  INjieshushijianDE =getElemnt(PageElmentExcle.getCellData(index, fiedColName), true, false, "","");index++;
//	  INchuchaidiquDE =getElemnt(PageElmentExcle.getCellData(index, fiedColName), true, false, "","");index++;
//	  INyujifeiyongDE =getElemnt(PageElmentExcle.getCellData(index, fiedColName), true, false, "","");index++;
//	  INchuchaishiyouDE =getElemnt(PageElmentExcle.getCellData(index, fiedColName), true, false, "","");index++;
//	  INchengbenfenpeiDE =getElemnt(PageElmentExcle.getCellData(index, fiedColName), true, false, "","");index++;
//	  INchenbenleixingDE =getElemnt(PageElmentExcle.getCellData(index, fiedColName), true, false, "","");index++;
//	  INfenpeibianhaoDE =getElemnt(PageElmentExcle.getCellData(index, fiedColName), true, false, "","");index=1;
//		
//		
//	  INyuangongbianhaoDA =getElemnt(PageElmentExcle.getCellData(index, dataColName), true, false, "","");index++;
//	  INyuangongxingmingDA =getElemnt(PageElmentExcle.getCellData(index, dataColName), true, false, "","");index++;
//	  INfeiyongleixingDA =getElemnt(PageElmentExcle.getCellData(index, dataColName), true, false, "","");index++;
//	  INchailvleixingDA =getElemnt(PageElmentExcle.getCellData(index, dataColName), true, false, "","");index++;
//	  INshifoujiekuanDA =getElemnt(PageElmentExcle.getCellData(index, dataColName), true, false, "","");index++;
//	  INkaishishijianDA =getElemnt(PageElmentExcle.getCellData(index, dataColName), true, false, "","");index++;
//	  INjieshushijianDA =getElemnt(PageElmentExcle.getCellData(index, dataColName), true, false, "","");index++;
//	  INchuchaidiquDA =getElemnt(PageElmentExcle.getCellData(index, dataColName), true, false, "","");index++;
//	  INqingshuruchengshiDA =getElemnt(PageElmentExcle.getCellData(index, dataColName), true, false, "","");index++;
//	  INyujifeiyongDA =getElemnt(PageElmentExcle.getCellData(index, dataColName), true, false, "","");index++;
//	  INchuchaishiyouDA =getElemnt(PageElmentExcle.getCellData(index, dataColName), true, false, "","");index++;
//	  INchenbenleixingDA =getElemnt(PageElmentExcle.getCellData(index, dataColName), true, false, "","");index++;
//	  INfenpeibianhaoDA =getElemnt(PageElmentExcle.getCellData(index, dataColName), true, false, "","");index=1;
//	}
//	else {
////		iOSFindAll path
//			}
	}
	
}

