package com.Pcitc.AppAutomationTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Pcitc.AppAutomationTest.base.TestBase;
import com.Pcitc.AppAutomationTest.pagesHelper.Location;
import com.Pcitc.AppAutomationTest.pagesHelper.TestInit;
import com.Pcitc.AppAutomationTest.utils.ExcelReader;


public class ESSP_ChaiLvShenQing  extends TestBase
{
	
	protected WebElement  LIchailvshenqingDE= null;
	protected WebElement  LIxinjianshenqingDE= null;
	protected WebElement   LIshenqingqingdanDE= null;

	protected  void  ESSP_ChaiLvShenQingListPage()
	{
	if (TestInit.IsAndroid)
	{
//		点击差旅申请进入列表页面
		WebElement chailvshenqing=getElemnt(Location.TextView_Ptext, true, true, "差旅申请", "");
		action.tap(chailvshenqing, 1000);
		LIchailvshenqingDE= getElemnt(Location.id, true, true, "cn.cooperative:id/title", "");
		LIxinjianshenqingDE= getElemnt(Location.id, true, true, "cn.cooperative:id/textTravelApplyNew", "");
		LIshenqingqingdanDE=  getElemnt(Location.id, true, true,"cn.cooperative:id/textTravelApplyList", "");
	}
	else {
		// ios  定位方式
		}
	}
//	
//	/**
//	 * 新建申请
//	 */
//	protected 	WebElement  newApp=null;
//	/**
//	 * 申请清单
//	 */
//	  newAppList=null ;
//	
//	/**
//	 * 差旅申请标题
//	 */
//	   title=null;
//	
//	/**
//	 * 主数据
//	 */
//	  Butten_MainData=null;
//
//	/**
//	 * 员工编号
//	 */
//	  Text_EmCode=null;
//	  Text_EmCodeData=null;
//	/**
//	 * 员工姓名
//	 */
//	  Text_EmName=null;
//	  Text_EmNameData=null;
//	/**
//	 * 费用类型
//	 */
//	  Text_FeeType=null;
//	  Text_FeeTypeData=null;
//	/**
//	 * 差旅类型
//	 */
//	  Butten_TravelType=null;
//	  Text_TravelTypeData=null;
//	/**
//	 * 是否借款
//	 */
//	  Butten_IsLoan=null;
//	  Text_IsLoanData=null;
//	/**
//	 * 数据
//	 */
//
//	
//
//
//
//
//	
////	get test page
//	protected  void  getTravelPage()
//	{
//		traveApp=getElemnt("", true, true,"差旅", "");
//	}
//	protected  void  getMainDataElement() 
//	{	
//		
////		获得新建差旅申请链接
//		newApp=super.getElemnt(Location.TextView_Ptext, true, true,"新建申请", "");
//		newApp.click();
//		try {
//			Thread.sleep(1500);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		title=getElemnt(Location.TextView_Ptext, true, true," 新建差旅申请", "");	
//		Butten_MainData=super.getElemnt(Location.TextView_Ptext, true, true, "主数据","");
//		
//		Text_EmCode=super.getElemnt(Location.TextView_Ptext, true, true, "员工编号","");
//		Text_EmCodeData=super.getElemnt(Location.TextView_Ptext_followingSiblingTextView_Pindex, true, true, "员工编号","1");
//	
//		Text_EmName=getElemnt(Location.TextView_Ptext, true, true, "员工姓名","");
//		Text_EmNameData=getElemnt(Location.TextView_Ptext_followingSiblingTextView_Pindex,true, true,"员工姓名","1");
//		
//		Text_FeeType=getElemnt(Location.TextView_Ptext, true, true,"费用类型","");
//		Text_FeeTypeData=getElemnt(Location.TextView_Ptext_followingSiblingTextView_Pindex, true, true,"费用类型","1");
//		
//		Butten_TravelType=getElemnt(Location.TextView_Ptext, true, true,"差旅类型","");
//		Text_TravelTypeData=getElemnt(Location.TextView_Ptext_followingSiblingTextView_Pindex, true, true,"差旅类型","1");
//		
//		Butten_IsLoan=getElemnt(Location.TextView_Ptext, true, true,"是否借款","");
//		Text_IsLoanData=getElemnt(Location.TextView_Ptext_followingSiblingTextView_Pindex,true, true,"是否借款","1");
//	}
//	/**
//	 *开始时间
//	 */
//	  beginTime=null;
//	  beginTimeData=null;
//	/**
//	 * 结束时间
//	 */
//	  endTime=null;
//	  endTimeData=null;
//	
//	/**
//	 * 出差地区
//	 */
//	  TraCountry=null;
//	  TraCountryData=null;
//	
//	/**
//	 * 出差城市
//	 */
//	
//	  TraCityData=null;
//	/**
//	 * 预计费用
//	 */
//	  ExpectAmount=null;	
//	  ExpectAmountData=null;	
//	/**
//	 * 出差事由
//	 */
//	  TraReasion=null;
//	  TraReasionData=null;
//	protected  void  getTraAppElement() 
//	{	
//		beginTime=getElemnt(Location.TextView_Ptext, true, true,"开始时间", "");	
//		beginTimeData=getElemnt(Location.TextView_Ptext_followingSiblingTextView_Pindex, true, true,"开始时间", "1");	
//		
//		endTime=getElemnt(Location.TextView_Ptext, true, true,"结束时间", "");	
//		endTimeData=getElemnt(Location.TextView_Ptext_followingSiblingTextView_Pindex, true, true,"结束时间", "1");	
//		
//		TraCountry=getElemnt(Location.TextView_Ptext, true, true,"出差地区", "");	
//		TraCountryData=getElemnt(Location.TextView_Ptext_followingSiblingTextView_Pindex, true, true,"出差地区", "1");	
//		
//		TraCityData=getElemnt(Location.EditText_Ptext, true, true,"请输入城市", "");	
//		
//		ExpectAmount	=getElemnt(Location.TextView_Ptext, true, true,"预计费用", "");	
//		ExpectAmountData=getElemnt(Location.TextView_Ptext_followingSiblingTextView_Pindex, true, true,"预计费用", "1");	
//		
//		TraReasion=getElemnt(Location.TextView_Ptext, true, true,"出差事由", "");	
//		TraReasionData=getElemnt(Location.EditText_Ptext, true, true,"请输入事由", "1");	
//	}
//	
//
//	/**
//	 * 成本分配
//	 */
//	  Butten_CostAllocation=null;	
//	/**
//	 * 成本类型
//	 */
//	  Text_CostType=null;
//	  Text_CostTypeData=null;
//	/**
//	 * 分配编号
//	 */
//	  Text_CostNO=null;
//	  Text_CostNOData=null;
//	
//	/**
//	 * 成本分配对象
//	 * @throws InterruptedException 
//	 */
//	protected  void  getCostAllocationElement() throws InterruptedException 
//	{	
//		By   by =By.xpath(Tools.getBy(Location.TextView_Ptext, "收据类型", ""));
//		action.swipe(by, "up", 10);
//		
//		Butten_CostAllocation=getElemnt(Location.TextView_Ptext, true, true, "成本分配","");
//		
//		Text_CostType=getElemnt(Location.TextView_Ptext, true, true, "成本类型","");
//		Text_CostTypeData=getElemnt(Location.TextView_Ptext_followingSiblingTextView_Pindex, true, true,"成本类型","1");
//		
//		
//		Text_CostNO=getElemnt(Location.TextView_Ptext, true, true, "分配编号","");
//		Text_CostNOData=getElemnt(Location.TextView_Ptext_followingSiblingTextView_Pindex, true, true,"分配编号","1");
//	}
//	/**
//	 * 支出计划
//	 */
//	  payPlan=null;
//
//	/**
//	 * 收据类型
//	 */
//	  receipType=null;
//	  receipTypeData=null;
//	/**
//	 * 日期   
//	 */                 
//	  payPlanDate=null;
//	  payPlanDateData=null;
//	/**
//	 * 货币
//	 */
//	  payPlanCurrency=null;
//	  payPlanCurrencyData=null;
//	
//	/**
//	 * 金额
//	 */
//	  payPlanAmounte=null;
//	  payPlanAmounteData=null;
//
//	/**
//	 * 信息
//	 */
//	  payPlanInfomation=null;
//	  payPlanInfomationData=null;
//	/**
//	 * 汇率
//	 */
//	  payPlanRate=null;
//	  payPlanRateData=null;
//	/**
//	 * 本位币
//	 */
//	   standardCurrency=null;
//	   standardCurrencyData=null;
//	
//	   add=null;
//	protected  void  gePayPlanElement() 
//	{
//		By by=By.xpath(Tools.getBy(Location.TextView_Ptext, "附加目的地", ""));
//		try {
//			action.swipe(by, "up", 100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		payPlan=getElemnt(Location.TextView_Ptext, true, true, "支出计划","");
//		
//		receipType=getElemnt(Location.TextView_Ptext, true, true, "收据类型","");
//		receipTypeData=getElemnt(Location.TextView_Ptext_followingSiblingTextView_Pindex, true, true,"收据类型","1");
//
//		payPlanDate=getElemnt(Location.TextView_Ptext, true, true, "日期","");
//		payPlanDateData=getElemnt(Location.TextView_Ptext_followingSiblingTextView_Pindex, true, true,"日期","1");
//		
//		payPlanCurrency	=getElemnt(Location.TextView_Ptext, true, true, "货币","");
//		payPlanCurrencyData=getElemnt(Location.TextView_Ptext_followingSiblingTextView_Pindex, true, true,"货币","1");
//
//		payPlanAmounte=getElemnt(Location.TextView_Ptext, true, true, "金额","");
//		payPlanAmounteData=getElemnt(Location.EditText_Ptext, true, true,"请输入金额","");
//		
//		payPlanInfomation=getElemnt(Location.TextView_Ptext, true, true, "信息","");
//		payPlanInfomationData=getElemnt(Location.TextView_Ptext_followingSiblingEditView_Pinde, true, true,"信息","1");
//	
//		 payPlanRate=getElemnt(Location.TextView_Ptext, true, true, "汇率","");
//	     payPlanRateData=getElemnt(Location.EditText_Ptext, true, true, "1.000000","");
//		
//		 standardCurrency=getElemnt(Location.TextView_Ptext_Pindex, true, true, "本位币","1");
//		 standardCurrencyData=getElemnt(Location.TextView_Ptext_followingSiblingTextView_Pindex, true, true, "本位币","1");
//			
//		 add=getElemnt(Location.TextView_Ptext, true, true, "添加","");
//	}
//
//	
//
//
//	/**
//	 *附加目的地
//	 */
//	   extedPlace=null;
//
//	/**
//	 * 温馨提示
//	 */
//	   tips=null;
//
//	/**
//	 * 提交
//	 */
//	   commit=null;
//	
//	protected  void  getExtedPlaceElement() throws InterruptedException
//	{
//		By   by =By.xpath(Tools.getBy(Location.Button_Ptext, "提交", ""));
//		commit=	action.swipe(by, "up", 10);
//		
//		extedPlace=getElemnt(Location.TextView_Ptext, true, true, "附加目的地","");
//		tips=getElemnt(Location.TextView_Ptext, true, true, "温馨提示: 附加目的地如填写请输入完整","");
//
//	}
//}
}