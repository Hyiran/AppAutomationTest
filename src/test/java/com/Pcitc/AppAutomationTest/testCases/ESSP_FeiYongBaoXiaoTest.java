package com.Pcitc.AppAutomationTest.testCases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.pages.ESSP_FeiYongBaoXiao;
import com.Pcitc.AppAutomationTest.pagesHelper.Location;
import com.Pcitc.AppAutomationTest.pagesHelper.PageFuntion;
import com.Pcitc.AppAutomationTest.pagesHelper.TestInit;
import com.Pcitc.AppAutomationTest.utils.KeyEvent;
import com.Pcitc.AppAutomationTest.utils.Log;

public class ESSP_FeiYongBaoXiaoTest extends ESSP_FeiYongBaoXiao
{
	
	String data="";
	@BeforeClass
	public void getPageElement()
	{ 	
	clasName=this.getClass().getSimpleName();
	beforeClass();
		
	}

	@Test(priority='1',description="费用报销-代办列表测试")
	public void ESSP_FeiYongBaoXiaoTest_ListPage() throws IOException
{
	String	caseNo="费用报销-代办列表测试";
		try 
		{
			
		beforeMethod(clasName, "listPage");
			
		Log.logInfo(caseNo, GetClassMethodName());	
		PageFuntion.logIn(getUserName("feiyongbaoxiao", "1"), getUserPassWord("feiyongbaoxiao", "1"));
			
//			进入列表页
		ESSP_FeiYongBaoXiaoListPage();
		int i=2;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), LIfeiyongbaoxiaoDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), LIpishenDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), LIdaibanDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), LIyibaanDE,  "", appiumDriver);
		i++;
		action.pressKeyCode(KeyEvent.fanHui);
		PageFuntion.logOut();
		afterMethod(10,clasName);		
		} 
		catch (Exception e)
		{
			PageFuntion.exceptionLogOutAndroid(endTime.toString());
			
		}	

}
	@Test(priority='2',description="费用报销-详情页测试")
	public void ESSP_FeiYongBaoXiaoTest_DetailsPage() throws IOException
		{
		try 
		{
			beforeMethod(clasName, "listPage");
			String caseNo="费用报销-详情页测试";
			Log.logInfo(caseNo, GetClassMethodName());	
			PageFuntion.logIn(getUserName("feiyongbaoxiao", "1"), getUserPassWord("feiyongbaoxiao", "1"));
			
			
//			进入列表页
			ESSP_FeiYongBaoXiaoListPage();
//			进入进入详情页	
			beforeMethod(clasName, "detailsPage");
			if (TestInit.IsAndroid) {
				 data=getGenDataExcleData(1, "费用报销");
			}
			else {
				
			}
			
			ESSP_FeiYongBaoXiaoDetails1(data);
		int i=1;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INyibanbaoxiaoDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INzhushujuDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INdanjubianhaoDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INyuangongbianhaoDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INyuangongxingmingDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INsuoshubumenDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INsuoshuzuzhiDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INchongxiaojiekuanDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INfeiyongleixingDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INyibanxinxiDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INbaoxiaoriqiDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INbaoxiaoshiyouDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INchengbenhejiDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INchenbenfenpeiDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INgongsidaimaDE,  "", appiumDriver);
		i++;

		i=4;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData),INyuangongbianhaoDA ,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData),INyuangongxingmingDA ,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData),INsuoshubumenDA ,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData),INsuoshuzuzhiDA ,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData),INchongxiaojiekuanDA ,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData),INfeiyongleixingDA ,  "", appiumDriver);
		i=i+3;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData),INbaoxiaoshiyouDA ,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData),INchengbenhejiDA ,  "", appiumDriver);
		i=i+2;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData),INgongsidaimaDA ,  "", appiumDriver);
		i++;
		
		int index=i;
		ESSP_FeiYongBaoXiaoDetails2();
		
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INchengbenfeipei2DE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), InshoujuxinxiDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INshoujuleixingDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INjineDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INriqiDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INxinxiDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INshenpiyijianDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INshenpirenDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INzhuangtaiDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INyijianDE,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, Field), INshijianDE,  "", appiumDriver);
		i++;

		i=index;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData),INchengbenfeipei2DA ,  "", appiumDriver);
		i=i+2;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData),INshoujuleixingDA ,  "", appiumDriver);
		i++;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData),INjineDA ,  "", appiumDriver);
		i=i+2;
		assertion.verifyEquals(caseNo,PageElmentExcle.getCellData(i, FieldData),INxinxiDA ,  "", appiumDriver);
		i++;
		action.pressKeyCode(KeyEvent.fanHui);
		action.pressKeyCode(KeyEvent.fanHui);
		PageFuntion.logOut();
		afterMethod(10,clasName);
		} 
		catch (Exception e)
		{
			PageFuntion.exceptionLogOutAndroid(endTime.toString());
			
		}		
		}
	@Test(priority='3',description="费用报销-项目经理批审")
	public void ESSP_FeiYongBaoXiaoTest_MangManyApp() throws IOException
{
		try 
		{
			String  caseNo="费用报销-项目经理批审";
			beforeMethod(clasName, "listPage");
				
			Log.logInfo(caseNo, GetClassMethodName());	
			PageFuntion.logIn(getUserName("feiyongbaoxiao", "1"), getUserPassWord("feiyongbaoxiao", "1"));
				
//				进入列表页
			ESSP_FeiYongBaoXiaoListPage();	
			PageFuntion.piShen_Android(caseNo, false, GenDataExcle, "费用报销", 2);
		action.pressKeyCode(KeyEvent.fanHui);
		PageFuntion.logOut();
		afterMethod(10,clasName);
		} 
		catch (Exception e)
		{
			PageFuntion.exceptionLogOutAndroid(endTime.toString());
			
		}	
		

}
	
	@Test(priority='4',description="费用报销-项目领导通过")
	public void ESSP_FeiYongBaoXiaoTest_LeaderAllow() throws IOException
{
		
		try 
		{
			
			
			String  caseNo="费用报销-项目领导通过";
			beforeMethod(clasName, "listPage");
				
			Log.logInfo(caseNo, GetClassMethodName());	
			PageFuntion.logIn(getUserName("feiyongbaoxiao", "2"), getUserPassWord("feiyongbaoxiao", "2"));
				
//				进入列表页
		ESSP_FeiYongBaoXiaoListPage();	
//		 进入数据详情
		if (TestInit.IsAndroid) {
			 data=getGenDataExcleData(1, "费用报销");
			 WebElement element=getElemntByYaml(Location.TextView_Ptext, true, true, data, "");
			 action.tap(element, 800);

		}
		else {
//			ios
			}
		
		PageFuntion.shenPiTongYong(caseNo, true, "");
		PageFuntion.yiBanChaKan(caseNo, data, "研究院:程玉超", "批准");
		
		PageFuntion.logOut();
		afterMethod(10,clasName);
		} 
		catch (Exception e)
		{
			PageFuntion.exceptionLogOutAndroid(endTime.toString());
			
		}		
}
	@Test(priority='5',description="费用报销-项目领导拒绝")
	public void ESSP_FeiYongBaoXiaoTest_LeaderRefause() throws IOException
{
		try 
		{
			
			
			String  caseNo="费用报销-项目领导拒绝";
			beforeMethod(clasName, "listPage");
				
			Log.logInfo(caseNo, GetClassMethodName());	
			PageFuntion.logIn(getUserName("feiyongbaoxiao", "2"), getUserPassWord("feiyongbaoxiao", "2"));
				
//				进入列表页
		ESSP_FeiYongBaoXiaoListPage();	
//		 进入数据详情
		if (TestInit.IsAndroid) {
			 data=getGenDataExcleData(2, "费用报销");
			 WebElement element=getElemntByYaml(Location.TextView_Ptext, true, true, data, "");
			 action.tap(element, 800);

		}
		else {
//			ios
			}
		
		PageFuntion.shenPiTongYong(caseNo, false, "自动化测试拒绝");
		PageFuntion.yiBanChaKan(caseNo, data, "研究院:赵雯", "拒绝");
		
		PageFuntion.logOut();
		afterMethod(10,clasName);
		afterClass(10, clasName);
		} 
		catch (Exception e)
		{
			PageFuntion.exceptionLogOutAndroid(endTime.toString());
			
		}		
}
	
	@Test(priority='6',description="差旅申请-项目领导拒绝")
	public void ESSP_FeiYongBaoXiaoTest_LeaderRefause2() throws IOException
{
		try 
		{
			
			
			String  caseNo="费用报销-项目领导拒绝";
			beforeMethod(clasName, "listPage");
				
			Log.logInfo(caseNo, GetClassMethodName());	
			PageFuntion.logIn(getUserName("feiyongbaoxiao", "2"), getUserPassWord("feiyongbaoxiao", "2"));
				
//				进入列表页
		ESSP_FeiYongBaoXiaoListPage();	
//		 进入数据详情
		if (TestInit.IsAndroid) {
			 data=getGenDataExcleData(3, "费用报销");
			 WebElement element=getElemntByYaml(Location.TextView_Ptext, true, true, data, "");
			 action.tap(element, 800);

		}
		else {
//			ios
			}
		
		PageFuntion.shenPiTongYong(caseNo, false, "自动化测试拒绝");
		PageFuntion.yiBanChaKan(caseNo, data, "研究院:赵雯", "拒绝");
		
		PageFuntion.logOut();
		afterMethod(10,clasName);
		afterClass(10, clasName);
		} 
		catch (Exception e)
		{
			PageFuntion.exceptionLogOutAndroid(endTime.toString());
			
		}		
}
}

