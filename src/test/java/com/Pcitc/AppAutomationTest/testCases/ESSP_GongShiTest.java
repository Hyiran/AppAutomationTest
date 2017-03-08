package com.Pcitc.AppAutomationTest.testCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.Test.assertTest;
import com.Pcitc.AppAutomationTest.pages.ESSP_GongShi;
import com.Pcitc.AppAutomationTest.pagesHelper.Location;
import com.Pcitc.AppAutomationTest.pagesHelper.PageFuntion;
import com.Pcitc.AppAutomationTest.pagesHelper.TestInit;
import com.Pcitc.AppAutomationTest.utils.KeyEvent;
import com.Pcitc.AppAutomationTest.utils.Log;

import sun.util.logging.resources.logging;

public class ESSP_GongShiTest extends ESSP_GongShi 
{
@BeforeClass
public void init()
{
	clasName=this.getClass().getSimpleName();
	beforeClass();
}
@Test(priority='1',description="工时-项目组长-批审")
public void  ESSP_GongShiTesXiaoZuPiShen() throws InterruptedException
{
	try 
{ 
		beforeMethod("", "");
		PageFuntion.logIn(getUserName("gongshi", "1"), getUserPassWord("gongshi","1"));
		String 	caseNo="工时-项目组长-批审";
		ESSP_GongShiListPage();
		int i=2;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), LIgongshishenpitiDE,  Field, appiumDriver);i++;
		assertion.verifyEquals(caseNo,"项目小组长", LIxingzhiDE,  Field, appiumDriver);i++;
		assertion.verifyEquals(caseNo,"正式员工", LIleixingDE,  Field, appiumDriver);i++;

		if (TestInit.IsAndroid) 
		{	action.tap(LIxingzhiDE, 1000);
			WebElement xiaozu=getElemntByYaml(Location.TextView_Ptext, true, true, "项目小组长", "");
			action.tap(xiaozu, 1000);
			
			action.tap(LIleixingDE, 1000);
			WebElement waixie=getElemntByYaml(Location.TextView_Ptext, true, true, "外协员工", "");
			action.tap(waixie, 1000);
		}
		else {
		
//			ios
			}
		PageFuntion.piShen_Android(caseNo,true, GenDataExcle, "工时", 2);
		
		Thread.sleep(4000);
		
		action.pressKeyCode(KeyEvent.fanHui);
		PageFuntion.logOut();
		afterMethod(12, clasName);
} catch (Exception e) 
	{
	PageFuntion.exceptionLogOutAndroid(endTime.toString());
}
	
}

@Test(priority='2',description="工时-项目经理单条-审批通过")
public void  ESSP_GongShiTestJingLiTongGuo() throws InterruptedException
{
	try {
		beforeMethod("", "");
		PageFuntion.logIn(getUserName("gongshi", "2"), getUserPassWord("gongshi","2"));
		String caseNo="工时-项目经理单条-审批通过";
		ESSP_GongShiListPage();

		if (TestInit.IsAndroid) 
			
		{	
			action.tap(LIxingzhiDE, 1000);
			WebElement xiangmu=getElemntByYaml(Location.TextView_Ptext, true, true, "项目经理", "");
			action.tap(xiangmu, 1000);
			
			action.tap(LIleixingDE, 1000);
			WebElement waixie=getElemntByYaml(Location.TextView_Ptext, true, true, "外协员工", "");
			action.tap(waixie, 1000);
			
			WebElement data1=getElemntByYaml(Location.TextView_Ptext, true, true, GenDataExcle.getCellData(1, "工时"), "");
			action.tap(data1, 1000);
			PageFuntion.shenPiGongshiAndroid(caseNo, true, caseNo);
			
			WebElement data2=getElemntByYaml(Location.TextView_Ptext, true, true, GenDataExcle.getCellData(2, "工时"), "");
			action.tap(data2, 1000);
			PageFuntion.shenPiGongshiAndroid(caseNo, true, caseNo);
		}
		else {
		
//			ios
			}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(4000);
		action.pressKeyCode(KeyEvent.fanHui);
		PageFuntion.logOut();
		afterMethod(12, clasName);
	} catch (Exception e) {
	PageFuntion.exceptionLogOutAndroid(endTime.toString());
	}

}


@Test(priority='3',description="工时-项目领导单条-审批通过")
public void  ESSP_GongShiTestLingDaoTongGuo()
{
	try {
		beforeMethod("", "");
		PageFuntion.logIn(getUserName("gongshi", "3"), getUserPassWord("gongshi","3"));
		String caseNo="工时-项目领导单条-审批通过";
		ESSP_GongShiListPage();
		
		
		if (TestInit.IsAndroid) 
		{	action.tap(LIxingzhiDE, 1000);
			WebElement lingdao=getElemntByYaml(Location.TextView_Ptext, true, true, "项目领导", "");
			action.tap(lingdao, 1000);
			
			action.tap(LIleixingDE, 1000);
			WebElement waixie=getElemntByYaml(Location.TextView_Ptext, true, true, "外协员工", "");
			action.tap(waixie, 1000);
			
			WebElement data1=getElemntByYaml(Location.TextView_Ptext, true, true, GenDataExcle.getCellData(1, "工时"), "");
			action.tap(data1, 1000);
			PageFuntion.shenPiGongshiAndroid(caseNo, true, caseNo);
			
			WebElement data2=getElemntByYaml(Location.TextView_Ptext, true, true, GenDataExcle.getCellData(2, "工时"), "");
			action.tap(data2, 1000);
			PageFuntion.shenPiGongshiAndroid(caseNo, true, caseNo);
		}
		else {
		
//			ios
			}
		
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		action.pressKeyCode(KeyEvent.fanHui);
		PageFuntion.logOut();
		afterMethod(12, clasName);
		afterMethod(12, clasName);
	} catch (Exception e) {
	PageFuntion.exceptionLogOutAndroid(e.toString());
	}
	
}

//@Test(priority='4',description="工时-部门秘书-审批拒绝")
public void  ESSP_GongShiTestMiShuJuJue()
{
	try {
		beforeMethod("", "");
		PageFuntion.logIn(getUserName("gongshi", "4"), getUserPassWord("gongshi","4"));
		String caseNo="工时-部门秘书-审批拒绝";
		ESSP_GongShiListPage();
		
		
		if (TestInit.IsAndroid) 
		{	action.tap(LIxingzhiDE, 1000);
			WebElement mishu=getElemntByYaml(Location.TextView_Ptext, true, true, "项目领导", "");
			action.tap(mishu, 1000);
			
			action.tap(LIleixingDE, 1000);
			WebElement waixie=getElemntByYaml(Location.TextView_Ptext, true, true, "外协员工", "");
			action.tap(waixie, 1000);
			
			WebElement data1=getElemntByYaml(Location.TextView_Ptext, true, true, GenDataExcle.getCellData(1, "工时"), "");
			action.tap(data1, 1000);
			PageFuntion.shenPiGongshiAndroid(caseNo, false, caseNo);
			
			WebElement data2=getElemntByYaml(Location.TextView_Ptext, true, true, GenDataExcle.getCellData(2, "工时"), "");
			action.tap(data2, 1000);
			PageFuntion.shenPiGongshiAndroid(caseNo, false, caseNo);
		}                                           
		else {
		
//			ios
			}
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		action.pressKeyCode(KeyEvent.fanHui);
		PageFuntion.logOut();
		Log.logInfo("工时测试完毕", GetClassMethodName());
		afterMethod(12, clasName);
	} catch (Exception e) {
	PageFuntion.exceptionLogOutAndroid(e.toString());
	}
	
}

}
