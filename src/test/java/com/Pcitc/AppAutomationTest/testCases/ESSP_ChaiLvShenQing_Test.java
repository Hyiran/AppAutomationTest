package com.Pcitc.AppAutomationTest.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.pages.ESSP_ChaiLvShenQing;
import com.Pcitc.AppAutomationTest.pagesHelper.Location;
import com.Pcitc.AppAutomationTest.pagesHelper.PageFuntion;
import com.Pcitc.AppAutomationTest.pagesHelper.TestInit;
import com.Pcitc.AppAutomationTest.utils.DataHandle;
import com.Pcitc.AppAutomationTest.utils.KeyEvent;
import com.Pcitc.AppAutomationTest.utils.Log;
import com.Pcitc.AppAutomationTest.utils.TimeString;



public class ESSP_ChaiLvShenQing_Test extends ESSP_ChaiLvShenQing
{
	
	@BeforeClass
	public void getPageElement()
	{ 	
	clasName=this.getClass().getSimpleName();
	beforeClass();
		
	}

	@Test(priority='1',description="差旅申请-列表页-测试")
	public void ESSP_ChaiLvShenQing_ListPage() throws IOException
		{
		
try 
{
	beforeMethod(clasName, "ESSP_ChaiLvShenQing_ListPage");
	String caseNo="差旅申请-列表页-测试";
	Log.logInfo(caseNo, GetClassMethodName());	
	PageFuntion.logIn(getUserName("chailvshenqing", "1"), getUserPassWord("chailvshenqing", "1"));

//	进入列表页
	ESSP_ChaiLvShenQingListPage();

int i=2;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), LIchailvshenqingDE,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);
i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), LIxinjianshenqingDE,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);
i++;
assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), LIshenqingqingdanDE,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);
i++;

action.pressKeyCode(KeyEvent.fanHui);
PageFuntion.logOut();
afterMethod(8,clasName);

} catch (Exception e)
{
	PageFuntion.exceptionLogOutAndroid(endTime.toString());
	
}
	
		}
	
	/**
	 * 测试详情页，执行前要在列表页
	 * @throws InterruptedException 
	 */
	@Test(priority='2',description="差旅申请-详情页-测试")
	public void ESSP_ChaiLvShenQing_Details() throws InterruptedException 
		{
		try {
			beforeMethod(clasName, "ESSP_ChaiLvShenQing_ListPage");
			String caseNo="差旅申请-详情页-测试";	
			Log.logInfo(caseNo, GetClassMethodName());	
			PageFuntion.logIn(getUserName("chailvshenqing", "1"), getUserPassWord("chailvshenqing", "1"));
			ESSP_ChaiLvShenQingListPage();
			
			beforeMethod(clasName, "ESSP_ChaiLvShenQing_Details");	
			ESSP_ChaiLvShenQingDetails1();
	int i=1;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INxijianchailvshenqingDE,  Field, appiumDriver);i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INzhushujuDE,  Field, appiumDriver);i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INyuangongbianhaoDE,  Field, appiumDriver);i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INyuangongxingmingDE,  Field, appiumDriver);i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INfeiyongleixingDE,  Field, appiumDriver);i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INchailvleixingDE,  Field, appiumDriver);i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INshifoujiekuanDE,  Field, appiumDriver);i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INkaishishijianDE,  Field, appiumDriver);i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INjieshushijianDE,  Field, appiumDriver);i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INchuchaidiquDE,  Field, appiumDriver);i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INyujifeiyongDE,  Field, appiumDriver);i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INchuchaishiyouDE,  Field, appiumDriver);i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INchengbenfenpeiDE,  Field, appiumDriver);i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INchenbenleixingDE,  Field, appiumDriver);i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INfenpeibianhaoDE,  Field, appiumDriver);i=1;

		
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData), INyuangongbianhaoDA,  FieldData, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData), INyuangongxingmingDA,  FieldData, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData), INfeiyongleixingDA,  FieldData, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData), INchailvleixingDA,  FieldData, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData), INshifoujiekuanDA,  FieldData, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,TimeString.getYMD(), INkaishishijianDA,  FieldData, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,TimeString.getYMD(), INjieshushijianDA,  FieldData, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData), INchuchaidiquDA,  FieldData, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData), INqingshuruchengshiDA,  FieldData, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData), INyujifeiyongDA,  FieldData, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData), INchuchaishiyouDA,  FieldData, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData), INchenbenleixingDA,  FieldData, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData), INfenpeibianhaoDA,  FieldData, appiumDriver);	i++;
	int index=i;

	action.tap(INchailvleixingDA, 1000);
	//Log.logInfo("ssss"+DataHandle."差旅类型", classMethodeName);
	PageFuntion.xialLaKuang_Android(caseNo, 2, PageElmentExcle,"差旅类型", 1);;

	action.tap(INchuchaidiquDA, 1000);
	PageFuntion.xialLaKuang_Android(caseNo, 10, PageElmentExcle, "出差地区", 1);

	action.sendKeyByExcle(INqingshuruchengshiDA, 1, DataHandle.getElementText(INqingshuruchengshiDA));
	action.sendKeyByExcle(INchuchaishiyouDA, 1, DataHandle.getElementText(INchuchaishiyouDE));

	//选择成本类型
	action.tap(INchenbenleixingDA, 1000);
	PageFuntion.xialLaKuang_Android(caseNo, 2, PageElmentExcle, "成本类型", 1);
	//分配编号
	action.tap(INfenpeibianhaoDA, 1000);
	PageFuntion.shuRuChaXun(caseNo,  PageElmentExcle.getCellData(1, "分配编号"), "MES质量管理软件V1.0研发项目");

	ESSP_ChaiLvShenQingDetails2();


	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INzhichujihuaDE,  Field, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INshoujuleixingDE,  Field, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INriqiDE,  Field, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INhuobiDE,  Field, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INjineDE,  Field, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INxinxiDE,  Field, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INhuilvDE,  Field, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INbenweibiDE,  Field, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INtianjiaDE,  Field, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INfujiamudidiDE,  Field, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INwenxintishiDE,  Field, appiumDriver);	i++;

	i=index;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData), INshoujuleixingDA,  FieldData, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,TimeString.getYMD(), INriqiDA,  FieldData, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData), INhuobiDA,  FieldData, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData), INjineDA,  FieldData, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData), INxinxiDA,  FieldData, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData), INhuilvDA,  FieldData, appiumDriver);	i++;
	assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData), INbenweibiDA,  FieldData, appiumDriver);	i++;

	//收据类型
	action.tap(INshoujuleixingDA, 1000);
	PageFuntion.xialLaKuang_Android(caseNo, 2, PageElmentExcle, "收据类型", 1);
	//货币
	action.tap(INhuobiDA, 1000);
	PageFuntion.xialLaKuang_Android(caseNo, 2, PageElmentExcle, "货币", 1);
	//金额
	action.sendKey(INjineDA, PageElmentExcle.getCellData(1, "金额数据"));
	//信息
	action.sendKey(INxinxiDA, PageElmentExcle.getCellData(1, "信息数据"));
	//汇率
	action.sendKey(INhuilvDA, PageElmentExcle.getCellData(1, "汇率数据"));

	By by=null;
	if (TestInit.IsAndroid)
	{
		PageFuntion.tiJiao_Android();
		changWaitTimeToVar(20);
		WebElement success=getElemntByYaml(Location.TextView_Ptext, true, true, "提交成功", "1");
		assertion.webElementIsNotNull(caseNo,success, "判断差旅申请是否提交成功", appiumDriver);
		PageFuntion.fanHui();
		Thread.sleep(3000);
		action.tap(LIshenqingqingdanDE, 1000);
		WebElement data=getElemntByYaml(Location.TextView_Ptext, true, true, "1016-"+TimeString.getYMD2(), "1");
	    String genDataNo=DataHandle.getElementText(data);
	    
	    Log.logInfo("差旅申请生成的单号："+genDataNo, GetClassMethodName());
	    assertion.webElementIsNotNull(caseNo,data, "判断 差旅申请单号是否获取成功", appiumDriver);
	    if (genDataNo!="无法定位元素") 
	    {
	     if (TestInit.IsAndroid) 
	     {
//			安卓存储行号 5
	    	 mysql.getSqlResault("update data set ESSP_FeiYongBaoXiaoTest='"+genDataNo+"' where datano=5",false); 
	    	 rs=mysql.getSqlResault("SELECT *  from data  ",true);
	    	 String sqldata=rs.get(4).get("ESSP_FeiYongBaoXiaoTest");
	    	 Log.logInfo("android生成的测试数据存入数据库为："+sqldata, GetClassMethodName());
		}
	     else {
//				ios 6
	       	 mysql.getSqlResault("update data set ESSP_FeiYongBaoXiaoTest='"+genDataNo+"' where datano=6",false);
	       	rs=mysql.getSqlResault("SELECT *  from data  ",true);
	    	 String sqldata=rs.get(5).get("ESSP_FeiYongBaoXiaoTest");
	    	 Log.logInfo("ios生成的测试数据存入数据库为："+sqldata, GetClassMethodName());
	     
	     }
	    }
	    PageFuntion.fanHui();
	    Thread.sleep(2000);
	    PageFuntion.fanHui();
	    PageFuntion.logOut();
	    Log.logInfo("差旅申请测试完毕", GetClassMethodName());
	    afterMethod(8,clasName);
	    afterClass(8,clasName);
	}
		else 
		{
//			iOSFindAll
		}
		} catch (Exception e)
		{
			PageFuntion.exceptionLogOutAndroid(e.toString());
			
		}
		


		}
}