package com.Pcitc.AppAutomationTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Pcitc.AppAutomationTest.base.TestBase;
import com.Pcitc.AppAutomationTest.pagesHelper.Location;
import com.Pcitc.AppAutomationTest.utils.Action;
import com.Pcitc.AppAutomationTest.utils.DataHandle;

public class CRM_KeHuGuanLi  extends TestBase
{

	protected WebElement LIkehuguanlilinkDE=null;
	protected WebElement LIkehuguanlititleDE=null;
	protected WebElement LIkehuguanlitianjiaDE=null;
	protected WebElement LIkehuguanlidaibanDE=null;
	protected WebElement  LIkehuguanlichakanDE=null;
	
	protected void CRM_KeHuGuanLi_ListPage() 
	{
	changWaitTimeToVar(20);
	LIkehuguanlilinkDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	action.tap(LIkehuguanlilinkDE, 800);
	changWaitTimeToVar(5);
	LIkehuguanlititleDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	LIkehuguanlitianjiaDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	LIkehuguanlidaibanDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	LIkehuguanlichakanDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
	
	}
	
	protected WebElement INkehuxinxishenbaoDE=null;
	protected WebElement INkehuxinxiDE=null;
	protected WebElement INkehuquanchengDE=null;
	protected WebElement INjituankehuDE=null;
	protected WebElement INshangjidanweiDE=null;
	protected WebElement INdakehujingliDE=null;
	protected WebElement INsuozaibumenDE=null;
	protected WebElement INkehubeijingDE=null;
	protected WebElement INguojiaDE=null;
	protected WebElement INdiquDE=null;
	protected WebElement INhangyeDE=null;
	protected WebElement INdizhiDE=null;
	protected WebElement INnianyingyeshouruDE=null;
	
	protected WebElement INkehuquanchengDA=null;
	protected WebElement INjituankehuDA=null;
	protected WebElement INshangjidanweiDA=null;
	protected WebElement INdakehujingliDA=null;
	protected WebElement INsuozaibumenDA=null;
	protected WebElement INkehubeijingDA=null;
	protected WebElement INguojiaDA=null;
	protected WebElement INdiquDA=null;
	protected WebElement INhangyeDA=null;
	protected WebElement INdizhiDA=null;
	protected WebElement INnianyingyeshouruDA=null;
	int index;
	protected void CRM_KeHuGuanLi_DetailsPage1() 
	{
		PageElmentExcleIndex=1;
		INkehuxinxishenbaoDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INkehuxinxiDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INkehuquanchengDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INjituankehuDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INshangjidanweiDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INdakehujingliDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INsuozaibumenDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INkehubeijingDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INguojiaDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INdiquDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INhangyeDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INdizhiDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INnianyingyeshouruDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		PageElmentExcleIndex=1;
		INkehuquanchengDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
		INjituankehuDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
		INshangjidanweiDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
//		INdakehujingliDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);
		PageElmentExcleIndex++;
		INsuozaibumenDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
		INkehubeijingDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
		INguojiaDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
		INdiquDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
		INhangyeDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
		INdizhiDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
		INnianyingyeshouruDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	index =PageElmentExcleIndex;
	}
	protected WebElement INshichangleibieDE =null;
	protected WebElement INzhongyaoxingDE =null;
	protected WebElement INqianzaixuqiuDE =null;
	protected WebElement INlianxirenxingxiDE =null;
	protected WebElement INxingmingDE =null;
	protected WebElement INbumenDE =null;
	protected WebElement INzhiwuDE =null;
	protected WebElement INyoujianDE =null;
	protected WebElement INdianhuaDE =null;
	protected WebElement INshoujiDE =null;
	
	protected WebElement INshichangleibieDA =null;
	protected WebElement INzhongyaoxingDA =null;
	protected WebElement INqianzaixuqiuDA =null;
	protected WebElement INxingmingDA =null;
	protected WebElement INbumenDA =null;
	protected WebElement INzhiwuDA =null;
	protected WebElement INyoujianDA =null;
	protected WebElement INdianhuaDA =null;
	protected WebElement INshoujiDA =null;
	protected void CRM_KeHuGuanLi_DetailsPage2() 
	{
		By by=By.xpath(DataHandle.getBy(Location.TextView, "手机", ""));
		action.swipe(by, "up", 5, false);
		INshichangleibieDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INzhongyaoxingDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INqianzaixuqiuDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INlianxirenxingxiDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INxingmingDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INbumenDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INzhiwuDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INyoujianDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INdianhuaDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		INshoujiDE=getElemntByExcle(PageElmentExcle, true, AndroidTitleLocatType, AndroidTitleLocatString);PageElmentExcleIndex++;
		PageElmentExcleIndex=index;
		INshichangleibieDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
		INzhongyaoxingDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
		INqianzaixuqiuDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
		INxingmingDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
		INbumenDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
		INzhiwuDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
		INyoujianDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
		INdianhuaDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
		INshoujiDA=getElemntByExcle(PageElmentExcle, true, AndroidDataLocatType, AndroidDataLocatString);PageElmentExcleIndex++;
	}
	}

