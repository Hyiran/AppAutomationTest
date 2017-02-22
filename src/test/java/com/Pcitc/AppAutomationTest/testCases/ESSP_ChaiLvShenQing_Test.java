package com.Pcitc.AppAutomationTest.testCases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.pages.ESSP_ChaiLvShenQing;
import com.Pcitc.AppAutomationTest.pagesHelper.PageFuntion;
import com.Pcitc.AppAutomationTest.pagesHelper.TestInit;
import com.Pcitc.AppAutomationTest.utils.KeyEvent;
import com.Pcitc.AppAutomationTest.utils.Log;


public class ESSP_ChaiLvShenQing_Test extends ESSP_ChaiLvShenQing
{
	
	@BeforeClass
	public void getPageElement()
	{ 	
	clasName=this.getClass().getSimpleName();
//	beforeClass(clasName);
		
	}

	@Test(priority='1',description="差旅申请-列表页-测试")
	public void ESSP_ChaiLvShenQing_ListPage() throws IOException
		{
		beforeMethod(clasName, "ESSP_ChaiLvShenQing_ListPage");
		caseNo="差旅申请-列表页-测试";
		PageFuntion.logIn(getUserName("chailvshenqing", "1"), getUserPassWord("chailvshenqing", "1"));
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
//		进入列表页
		ESSP_ChaiLvShenQingListPage();
	
	int i=2;
	assertion.verifyEquals(PageElmentExcle.getCellData(i, "字段"), LIchailvshenqingDE,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);
	i++;
	assertion.verifyEquals(PageElmentExcle.getCellData(i, "字段"), LIxinjianshenqingDE,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);
	i++;
	assertion.verifyEquals(PageElmentExcle.getCellData(i, "字段"), LIshenqingqingdanDE,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);
	i++;

		}
	
	/**
	 * 测试详情页，执行前要在列表页
	 */
//	@Test(priority='2',description="差旅申请-详情页-测试")
	public void ESSP_ChaiLvShenQing_Details() 
		{
		beforeMethod(clasName, "ESSP_ChaiLvShenQing_Details");
		caseNo="差旅申请-详情页-测试";	
		ESSP_ChaiLvShenQingDetails1();
	int i=1;
	assertion.verifyEquals(PageElmentExcle.getCellData(i, "字段"), INxijianchailvshenqingDE,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
	assertion.verifyEquals(PageElmentExcle.getCellData(i, "字段"), INzhushujuDE,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
	assertion.verifyEquals(PageElmentExcle.getCellData(i, "字段"), INyuangongbianhaoDE,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
	assertion.verifyEquals(PageElmentExcle.getCellData(i, "字段"), INyuangongxingmingDE,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
	assertion.verifyEquals(PageElmentExcle.getCellData(i, "字段"), INfeiyongleixingDE,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
	assertion.verifyEquals(PageElmentExcle.getCellData(i, "字段"), INchailvleixingDE,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
	assertion.verifyEquals(PageElmentExcle.getCellData(i, "字段"), INshifoujiekuanDE,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
	assertion.verifyEquals(PageElmentExcle.getCellData(i, "字段"), INkaishishijianDE,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
	assertion.verifyEquals(PageElmentExcle.getCellData(i, "字段"), INjieshushijianDE,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
	assertion.verifyEquals(PageElmentExcle.getCellData(i, "字段"), INchuchaidiquDE,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
	assertion.verifyEquals(PageElmentExcle.getCellData(i, "字段"), INyujifeiyongDE,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
	assertion.verifyEquals(PageElmentExcle.getCellData(i, "字段"), INchuchaishiyouDE,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
	assertion.verifyEquals(PageElmentExcle.getCellData(i, "字段"), INchengbenfenpeiDE,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
	assertion.verifyEquals(PageElmentExcle.getCellData(i, "字段"), INchenbenleixingDE,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
	assertion.verifyEquals(PageElmentExcle.getCellData(i, "字段"), INfenpeibianhaoDE,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i=1;

	
assertion.verifyEquals(PageElmentExcle.getCellData(i, "数据"), INyuangongbianhaoDA,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
assertion.verifyEquals(PageElmentExcle.getCellData(i, "数据"), INyuangongxingmingDA,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
assertion.verifyEquals(PageElmentExcle.getCellData(i, "数据"), INfeiyongleixingDA,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
assertion.verifyEquals(PageElmentExcle.getCellData(i, "数据"), INchailvleixingDA,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
assertion.verifyEquals(PageElmentExcle.getCellData(i, "数据"), INshifoujiekuanDA,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
assertion.verifyEquals(PageElmentExcle.getCellData(i, "数据"), INkaishishijianDA,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
assertion.verifyEquals(PageElmentExcle.getCellData(i, "数据"), INjieshushijianDA,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
assertion.verifyEquals(PageElmentExcle.getCellData(i, "数据"), INchuchaidiquDA,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
assertion.verifyEquals(PageElmentExcle.getCellData(i, "数据"), INqingshuruchengshiDA,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
assertion.verifyEquals(PageElmentExcle.getCellData(i, "数据"), INyujifeiyongDA,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
assertion.verifyEquals(PageElmentExcle.getCellData(i, "数据"), INchuchaishiyouDA,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
assertion.verifyEquals(PageElmentExcle.getCellData(i, "数据"), INchenbenleixingDA,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i++;
assertion.verifyEquals(PageElmentExcle.getCellData(i, "数据"), INfenpeibianhaoDA,  PageElmentExcle.getCellData(i, "断言句"), appiumDriver);	i=1;

	//	回到主页
		action.pressKeyCode(KeyEvent.fanHui);
		}
//	@Test(priority=1,description="差旅申请－主数据")
//	public void travelAppTestMainData() throws InterruptedException 
//	{
//    String  caseNO="安卓-差旅申请－主数据表单填入";
////    login
//	PageFuntion.logIn(getUserName("chailvshenqing", "1"), getUserPassWord("chailvshenqing", "1"));
////	fix waite time to 50
//	changWaitTimeToVar(50);
//
////	to test page
//	Thread.sleep(3000);
//	getTravelPage();
//	action.tap(traveApp, 1000);
//	
//	changWaitTimeToDefault();
//	
////	  页面对象
//	 getMainDataElement();
//		
//	//断言默认对象
//	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(title), true,pageElementExcle.getCellData(row, 3), driver);row ++;
//
//	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(Butten_MainData), true,pageElementExcle.getCellData(row, 3), driver);row ++;
//	
//	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(Text_EmCode), true,pageElementExcle.getCellData(row, 3), driver);
//	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 2), Tools.getElementText(Text_EmCodeData), false,pageElementExcle.getCellData(row, 3), driver);row ++;
//
//	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(Text_EmName), true,pageElementExcle.getCellData(row, 3), driver);
//	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 2), Tools.getElementText(Text_EmNameData), false,pageElementExcle.getCellData(row, 3), driver);row ++;
//
//	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(Text_FeeType), true,pageElementExcle.getCellData(row, 3), driver);
//	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 2), Tools.getElementText(Text_FeeTypeData), false,pageElementExcle.getCellData(row, 3), driver);row ++;
//
//	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(Butten_TravelType), true,pageElementExcle.getCellData(row, 3), driver);
//	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 2), Tools.getElementText(Text_TravelTypeData), false,pageElementExcle.getCellData(row, 3), driver);row ++;
//
//	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(Butten_IsLoan), true,pageElementExcle.getCellData(row, 3), driver);
//	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 2), Tools.getElementText(Text_IsLoanData), false,pageElementExcle.getCellData(row, 3), driver);row ++;
//	
//	
//	action.tap(Text_IsLoanData, 1000);
//	PageFuntion.xialLaKuang(caseNO, "shifoujiekuan", xml, pageElementExcle);
//	
//	action.tap(Text_TravelTypeData, 1000);
//	PageFuntion.xialLaKuang(caseNO, "chailvleixing", xml, pageElementExcle);
//	
//	WebElement element=getElemnt(Location.TextView_Ptext, true, true, "境外差旅", "");
//	Assertion.verifyEquals(caseNO, Tools.getElementText(element), "境外差旅", false,"差旅类型修改是否成功", driver);
//	
//}
//	  @Test(priority=2,description="新建差旅申请－差旅申请")
//		public void travelAppTestTravelApp() 
//	  {
//			Log.logInfo("新建差旅申请－差旅申请");
////			  定义测试用例编号
//		 	 String  caseNO="新建差旅申请－差旅申请";
//		 	 getTraAppElement();
//		 	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(beginTime), true,pageElementExcle.getCellData(row, 3), driver);
//			Assertion.verifyEquals(caseNO,TimeString.getYMD(), Tools.getElementText(beginTimeData), false,pageElementExcle.getCellData(row, 3), driver);row ++;
//
//			Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(endTime), true,pageElementExcle.getCellData(row, 3), driver);
//			Assertion.verifyEquals(caseNO,TimeString.getYMD(), Tools.getElementText(endTimeData), false,pageElementExcle.getCellData(row, 3), driver);row ++;
//		
//			Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(TraCountry), true,pageElementExcle.getCellData(row, 3), driver);
//			Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 2), Tools.getElementText(TraCountryData), false,pageElementExcle.getCellData(row, 3), driver);row ++;
//			
//
//			Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 2), Tools.getElementText(TraCityData), false,pageElementExcle.getCellData(row, 3), driver);row ++;
//			
//			Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(ExpectAmount), true,pageElementExcle.getCellData(row, 3), driver);
//			Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 2), Tools.getElementText(ExpectAmountData), false,pageElementExcle.getCellData(row, 3), driver);row ++;
//			
//			
//			Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(TraReasion), true,pageElementExcle.getCellData(row, 3), driver);
//			Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 2), Tools.getElementText(TraReasionData), false,pageElementExcle.getCellData(row, 3), driver);row ++;
//			
//			TraCountryData.click();
////			PageFuntion.d(caseNO, true, true,true ,"请选择国家", getExcle("差旅申请", "差旅申请下拉列表"), 13, "德国", "出差地区"); 	
//			PageFuntion.xialLaKuang(caseNO, "chuchaidiqu", xml, pageElementExcle);
//			WebElement element=getElemnt(Location.TextView_Ptext, true, true, "德国", "");
//			Assertion.verifyEquals(caseNO, Tools.getElementText(element), "德国", false,"请选择国家选择后", driver);
//			
//			TraCityData.sendKeys("慕尼黑");
//			WebElement city=getElemnt(Location.EditText_Ptext, true, true, "慕尼黑", "");
//			Text_EmCode.click();
//			Assertion.verifyEquals(caseNO, Tools.getElementText(city), "慕尼黑", false,"出差城市文本框输入后", driver);
//			
//			TraReasionData.sendKeys("公务出差");
//			WebElement reason=getElemnt(Location.EditText_Ptext, true, true, "公务出差", "");
//			Assertion.verifyEquals(caseNO, Tools.getElementText(reason), "公务出差", false,"出差是由文本框输入后", driver);
//	  }
//	  
//	  @Test(priority=3,description="新建差旅申请－成本分配")
//		public void travelAppTestCostAllocation() throws InterruptedException 
//	  {
////		  getMainDataElement();
//			Log.logInfo("新建差旅申请－成本分配");
////			  定义测试用例编号
//		   String  caseNO="新建差旅申请－成本分配";
//		 	 getCostAllocationElement();
//		 	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(Butten_CostAllocation), true,pageElementExcle.getCellData(row, 3), driver);row ++;
//	
//			Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(Text_CostType), true,pageElementExcle.getCellData(row, 3), driver);
//		 	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 2), Tools.getElementText(Text_CostTypeData), false,pageElementExcle.getCellData(row, 3), driver);row ++;
//		 	
//			Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(Text_CostNO), true,pageElementExcle.getCellData(row, 3), driver);
//		 	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 2), Tools.getElementText(Text_CostNOData), false,pageElementExcle.getCellData(row, 3), driver);row ++;
//		 
//		 	Text_CostTypeData.click();
////			PageFuntion.getSelete(caseNO, true,true, true, "请选择成本分配", getExcle("差旅申请", "差旅申请下拉列表"),5, "成本中心", "成本类型"); 	
//		 	PageFuntion.xialLaKuang(caseNO, "chengbenleixing", xml, pageElementExcle);
//		 	WebElement CostType=getElemnt(Location.TextView_Ptext, true, true, "项目编号", "");
//			Assertion.verifyEquals(caseNO, Tools.getElementText(CostType), "项目编号", false,"成本类型选择后", driver);
//			
//			Text_CostNOData.click();
//			PageFuntion.shuRuChaXun(caseNO, true, "项目编号", "请输入搜索的内容", xml.getElementText("./*/wbs"), xml.getElementText("./*/wbsname"));
//			WebElement code=getElemnt(Location.TextView_Ptext, true, true, xml.getElementText("./*/wbsname"), "");
//			Assertion.verifyEquals(caseNO,Tools.getElementText(Text_CostNOData),  Tools.getElementText(Text_CostNOData), false,"成本类型选择后", driver);
//	  }
//	  @Test(priority=4,description="新建差旅申请－支出计划")
//		public void travelAppTestExtedPlace() 
//	  {
//		  gePayPlanElement() ;
//			Log.logInfo("新建差旅申请－支出计划");
////			  定义测试用例编号
//		   String  caseNO="新建差旅申请－支出计划";
//		 	 
//		 	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(payPlan), true,pageElementExcle.getCellData(row, 3), driver);row ++;
//	
//			Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(receipType), true,pageElementExcle.getCellData(row, 3), driver);
//		 	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 2), Tools.getElementText(receipTypeData), false,pageElementExcle.getCellData(row, 3), driver);row ++;
//	  
//			Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(payPlanDate), true,pageElementExcle.getCellData(row, 3), driver);
//		 	Assertion.verifyEquals(caseNO,TimeString.getYMD(), Tools.getElementText(payPlanDateData), false,pageElementExcle.getCellData(row, 3), driver);row ++;
//			
//		 	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(payPlanCurrency), true,pageElementExcle.getCellData(row, 3), driver);
//		 	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 2), Tools.getElementText(payPlanCurrencyData), false,pageElementExcle.getCellData(row, 3), driver);row ++;
//			
//		 	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(payPlanAmounte), true,pageElementExcle.getCellData(row, 3), driver);
//		 	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 2), Tools.getElementText(payPlanAmounteData), false,pageElementExcle.getCellData(row, 3), driver);row ++;
//			
//		 	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(payPlanInfomation), true,pageElementExcle.getCellData(row, 3), driver);
//		 	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 2), Tools.getElementText(payPlanInfomationData), false,pageElementExcle.getCellData(row, 3), driver);row ++;
//		 	
//			Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(payPlanRate), true,pageElementExcle.getCellData(row, 3), driver);
//		 	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 2), Tools.getElementText(payPlanRateData), false,pageElementExcle.getCellData(row, 3), driver);row ++;
//		 	
//			Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(standardCurrency), true,pageElementExcle.getCellData(row, 3), driver);
//		 	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 2), Tools.getElementText(standardCurrencyData), false,pageElementExcle.getCellData(row, 3), driver);row ++;
//		 	
//			Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(add), true,pageElementExcle.getCellData(row, 3), driver);row ++;
//		
////		 	 选择收据类型
//		 	receipTypeData.click();
////			PageFuntion.getSelete(caseNO, true,true, true, "请选择收据类型", getExcle("差旅申请", "差旅申请下拉列表"),5, "差旅费-差旅补助", "收据类型"); 	
//		 	PageFuntion.xialLaKuang(caseNO, "shoujuleixing", xml, pageElementExcle);
//		 	WebElement Type=getElemnt(Location.TextView_Ptext, true, true, "差旅费-差旅补助", "");
//			Assertion.verifyEquals(caseNO,"差旅费-差旅补助（赛威等专用）" , Tools.getElementText(Type), false,"收据类型下拉列表选择后", driver);
//			
////		 	 选择货币
//			payPlanCurrencyData.click();
////			PageFuntion.getSelete(caseNO, true, true,true, "请选择货币类型", getExcle("差旅申请", "差旅申请下拉列表"),12, "美元", "货币"); 	
//			PageFuntion.xialLaKuang(caseNO, "huobi", xml, pageElementExcle);
//			WebElement cu=getElemnt(Location.TextView_Ptext, true, true, "美元", "");
//			Assertion.verifyEquals(caseNO, Tools.getElementText(cu), "美元", false,"货币下拉列表选择后", driver);
//			
////		 	 输入金额
//			Tools.elementSedKey(payPlanAmounteData, "100");
//			WebElement amount=getElemnt(Location.EditText_Ptext, true, true, "100", "");
//			Assertion.verifyEquals(caseNO,  "100",Tools.getElementText(amount), false,"金额输入后", driver);
//			
////		 	 输入信息
//			Tools.elementSedKey(payPlanInfomationData, "支出计划信息");
//			WebElement inf=getElemnt(Location.EditText_Ptext, true, true, "支出计划信息", "");
//			Assertion.verifyEquals(caseNO, "支出计划信息", Tools.getElementText(inf), false,"信息输入后", driver);
////		 	 输入汇率
//			Tools.elementSedKey(payPlanRateData, "2.5");
//			WebElement rate=getElemnt(Location.EditText_Ptext, true, true, "2.5", "");
//			Assertion.verifyEquals(caseNO,"2.5", Tools.getElementText(rate), false,"汇率输入后", driver);
//				
//			
//	  }
//	  @Test(priority=5,description="新建差旅申请－提交")
//		public void travelAppTestSub() throws InterruptedException, WriteException 
//	  {
//			Log.logInfo("新建差旅申请－提交");
////			  定义测试用例编号
//		   String  caseNO="新建差旅申请－提交";
//		   getExtedPlaceElement();
//		 	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(extedPlace), true,pageElementExcle.getCellData(row, 3), driver);row ++;	
//			Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(tips), true,pageElementExcle.getCellData(row, 3), driver);row++;
//		 	Assertion.verifyEquals(caseNO,pageElementExcle.getCellData(row, 1), Tools.getElementText(commit), false,pageElementExcle.getCellData(row, 3), driver);row ++;
//		 	Thread.sleep(2000);
//		 	action.tap(commit, 300);
//		 	changWaitTimeToVar(10);
//	  WebElement tElement=getElemnt(Location.TextView_Ptext, true, true, "提交结果", "");
//	  Assertion.webElementIsNotNull(caseNO, tElement, "判断差旅申请是否提报成功", driver);
//	  
//
//	  PageFuntion.fanHui();
//	  
//	  newAppList=getElemnt(Location.TextView_Ptext, true, true, "申请清单", "");
//	  newAppList.click();
//	  Thread.sleep(5000);
//	  WebElement data=getElemnt(Location.TextView_Ptext_followingSiblingTextView_Pindex, true, true, "申请单号:", "1");
//	  String genDataNo=Tools.getElementText(data);
//	  Assertion.webElementIsNotNull(caseNO, data, "判断 差旅申请单号是否获取成功", driver);
//	  if (genDataNo!="无法定位元素") 
//	  {
//
//		  genDatainsertExcleData(genDataNo, 2, 1);
//	  }
//	  PageFuntion.fanHui();
//	 PageFuntion.fanHui();
//	  }
}
