package com.Pcitc.AppAutomationTest.pagesHelper;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Pcitc.AppAutomationTest.base.TestBase;

import com.Pcitc.AppAutomationTest.utils.DataHandle;
import com.Pcitc.AppAutomationTest.utils.Log;
import com.Pcitc.AppAutomationTest.utils.ExcelReader;
import com.Pcitc.AppAutomationTest.utils.KeyEvent;
import com.Pcitc.AppAutomationTest.utils.Log;
import com.Pcitc.AppAutomationTest.utils.XMLParase;



public  class  PageFuntion extends TestBase
{

	 /**
	  * 登录方法-当前页面必需在登录页面
	  * @param useName  登录用户名
	  * @param Password 登录用户密码
	  */
	 public static void logIn (String  useName,String Password) 
	 { 
		 if (TestInit.IsAndroid)
		 {
			 WebElement Text_useNamae= appiumDriver.findElement(By.id("cn.cooperative:id/username"));
			 Text_useNamae.click();
			 
			Text_useNamae.sendKeys(useName);
			WebElement Text_Password= appiumDriver.findElement(By.id("cn.cooperative:id/password"));
			Text_Password.sendKeys(Password);
					
			WebElement button_Commit=appiumDriver.findElement(By.id("cn.cooperative:id/loginbutton"));
			action.tap(button_Commit, 500);	 	
		}
		else
		{
			
		}
	
	 }
	 /**
	  * 退出方法
	 * @throws InterruptedException 
	  */
	 public static void logOut () 
	 {
		 if (TestInit.IsAndroid) 
		 {
				//点击设置
				WebElement button_seting=getElemntByYaml(Location.id, true, true, "cn.cooperative:id/iv_setting", "");			
				action.tap(button_seting, 1000);
						
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
					// TODO: handle exception
				}					
//					点击注销帐户
						WebElement button_Louout=getElemntByYaml(Location.Button_Ptext, true, true, "注销账户", "");			
//						button_Louout.click();
						appiumDriver.tap(1, button_Louout, 1000);
						
//						点击确定
						WebElement button_ConfirmLouout=getElemntByYaml(Location.Button_Ptext, true, true, "确定", "");			
						action.tap(button_ConfirmLouout, 1000); 
		}
		 else {
			
		}
	
		

	 }
	 
	 public static WebElement manyApp=null;
	 public static String manyAppLocalType=Location.Button_Ptext;
	 public static String  manyAppLocalData="批审";
	 public static WebElement Data;
	/**
	 * 处理批审操作
	 * @param caseNo  用例编号
	 * @param e 	批审数据的excle对象
	 * @param col   列名
	 * @param size  批审数据的个数
	 */
public   static void piShen(String caseNo,ExcelReader e,String col,int size) throws InterruptedException 
	{
//	获得批审按钮
	 manyApp=getElemntByYaml(manyAppLocalType, true, true, manyAppLocalData,"");
//	断言批审按钮是否存在
	TestBase.assertion.webElementIsNotNull( manyApp,"批审按钮是否存在", appiumDriver);

//如果批审被定位点击按钮
if (manyApp!=null)
{
	action.tap(manyApp, 300);
	Log.logInfo(caseNo+"批审按钮已经点击",GetClassMethodName());
	
//	如果批审的数据只有一条，那么就只处理一个,点击它
	if (size==1)
	{
			try 
			{
	//			处理所在数据列的第一条数据
				WebElement data=getElemntByYaml(Location.TextView_Ptext, true, true, e.getCellData(1, col), "");
				data.click();
				Log.logInfo(caseNo+"批审1条数据:"+DataHandle.getElementText(Data)+"已经被选中",GetClassMethodName());
			} catch (Exception e1) 
			{
				Log.logError(caseNo+"批审1条数据，数据无法定位，数据为:"+e.getCellData(1, col),GetClassMethodName());		
			}
		
	}
//	如果多个批审数据则依次选择
	else
	{

		for (int i = 1; i <=size; i++) 
		{
			Log.logInfo(caseNo+"需要批审"+size+"条数据",GetClassMethodName());
			
				try {
				//勾选数据
				
					Data=getElemntByYaml(Location.TextView_Ptext, true, true, e.getCellData(i, col), "");
					Data.click();
					Log.logInfo(caseNo+"批审-第"+i+"条数据:"+DataHandle.getElementText(Data)+"已经被选中",GetClassMethodName());
					}
				catch (Exception e3) 
					{
					Log.logError(caseNo+"批审时找不到数据，数据为:"+DataHandle.getElementText(Data)+"截图："+caseNo+DataHandle.getElementText(Data),GetClassMethodName());	
//					screenShots.takeScreenshot(caseNo+DataHandle.getElementText(Data));
					}
		}
	}

	
//	点击审批按钮
	try {

		WebElement app=getElemntByYaml(Location.Button_Ptext, true, true, "审批", "");
		action.tap(app, 300);
		} catch (Exception e4)
		{
		Log.logError(caseNo+"批审－找不到审批按钮",GetClassMethodName());
		}	
	
// 点确定按钮
	try 
		{
		WebElement sure=getElemntByYaml(Location.Button_Ptext, true, true, "确定", "");
//		action.tap(sure, 300);
		} catch (Exception e5)
		{
		Log.logError("批审－找不到确定按钮",GetClassMethodName());
		}
}
else 
	{
//		TestBase.screenShots.takeScreenshot(caseNo+"-无法点击批审");
		Log.logError("批审按钮 不存在，无法点击:见截图："+caseNo+"-无法点击批审",GetClassMethodName());
	}

	}
/**
 * 工时 审批
 * @param caseNo 用例编号
 * @param isAgree  是否同意
 * @param options  审批意见
 */
public static void  shenPiGongshi(String caseNo,boolean isAgree,String options) 
{
	WebElement  agree=null;
	WebElement  disAgree=null;
	WebElement  defaultOptions=null;
	WebElement  submit=null;
	try {
		  agree=getElemntByYaml(Location.TextView_Ptext, true, true, "同意", "");
		  disAgree=getElemntByYaml(Location.TextView_Ptext, true, true, "拒绝", "");
		  defaultOptions=getElemntByYaml(Location.EditText_Pindex, true, true, "1", "");
		  submit=getElemntByYaml(Location.Button_Ptext, true, true, "提交", "");
	} catch (Exception e) {
		// TODO: handle exception
	}
		
		 TestBase.assertion.webElementIsNotNull( agree, "审批-同意按钮是否存在", appiumDriver);
		 TestBase.assertion.webElementIsNotNull( disAgree, "审批-拒绝按钮是否存在", appiumDriver);
		 TestBase.assertion.webElementIsNotNull( submit, "审批-默认意见是否为空", appiumDriver);
		 TestBase.assertion.webElementIsNotNull( defaultOptions, "审批-提交按钮是否存在", appiumDriver);
		 
//		 判断是否要拒绝
		 if (isAgree!=true) 
		 
		 {
			 
			 WebElement  disAgre=getElemntByYaml(Location.ImageView_Pindex, true, true, "1", "");
			 action.tap(disAgre, 1000);
		}
		 
//		 判断输入要输入原因
		 if (options!="") 
			 
		 {
			 
			 action.sendKey(defaultOptions, options);
		}
		 
//		 点击提交
		 action.tap(submit, 1000);
}
/**
 * 查看已办数据，当前页必须在列表页
 */
public static void yiBanChaKan(String caseNo,String Data,String appMan,String status) 
{
	try {
//		进入已办列表
		WebElement alreadyApp=getElemntByYaml(Location.TextView_Ptext, true, true, "已办", "");
		action.tap(alreadyApp, 1000);
		Log.logInfo(caseNo+"：已进入已办列表",GetClassMethodName());
		
	} catch (Exception e) 
	{		
		Log.logError(caseNo+":找不到已办按钮",GetClassMethodName());
				
	}
//	滑动到要定位到数据
	By by =By.xpath(DataHandle.getBy(Location.TextView_Ptext, Data, ""));
	Log.logInfo("需要滑动找到的数据为："+Data+",采取的定位器："+DataHandle.getBy(Location.TextView_Ptext, Data, ""),GetClassMethodName());
	
	WebElement  getData=action.swipe(by, "up", 10);
	if (getData==null)
	{
		Log.logError(caseNo+":在已办中找不到数据！返回到主页",GetClassMethodName());
		fanHui();
		
	}
	else 
	{
	 action.tap(getData, 1000);	
	 Log.logInfo(caseNo+"：已进入已办数据详情页",GetClassMethodName());
	}
	
	
//	滑动到要定位到数据
	 by =By.xpath(DataHandle.getBy(Location.TextView_Ptext, appMan, ""));
	Log.logInfo("需要滑动找到的数据为："+appMan+",采取的定位器："+DataHandle.getBy(Location.TextView_Ptext, appMan, ""),GetClassMethodName());
	WebElement  getDataAppMan=action.swipe(by, "up", 10);
	if (getDataAppMan==null) 
	{
		Log.logError(caseNo+":在已办-数据详情中找不到审批人！请检查参数！返回到主页",GetClassMethodName());
		fanHui();
		fanHui();
	}
	else 
	{
		
		   List<WebElement>	appStatus=getElemnts(Location.TextView_Ptext_following_sibling_TextView, appMan, "");
		   if (appStatus==null) 
		   {
			   Log.logError(caseNo+":在已办-数据详情中找不到审批的相关审批信息，请检查定位方式！返回到主页",GetClassMethodName());
			   fanHui();
			   fanHui();
		   }
		   ArrayList<String> appInfor=new ArrayList<String>();
		  
		   try {
			   for (int i = 0; i <5; i++)
			   {
				   appInfor.add(DataHandle.getElementText(appStatus.get(i)));
			   }
			  
		} catch (Exception e)
		  {
			Log.logInfo(caseNo+"已获取审批人的审批信息",GetClassMethodName());
		  }
		   
	
		   boolean right=appInfor.contains(status);
		   TestBase.assertion.isTrue(caseNo, right, "判断审批状态是否为"+status, appiumDriver);
	
		   fanHui();
		   fanHui();
		   Log.logInfo(" 返回主页面",GetClassMethodName());
		   	   
	}
}		
		
	
	




/**
* 点击返回
* 
*/
public   static void fanHui() 
	{	
	if (TestInit.IsAndroid)
	{
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		action.pressKeyCode(KeyEvent.fanHui);
	}
	else
	{
		
	}
	}



/**
 * 处理日期控件
 * @param No
 * @param date
 * @throws InterruptedException
 */
public void  riQiXuanZe(String  No,String date) throws InterruptedException{
//	定义年月日控件的滑动次数
	int  YearTimes=10;
	int  MonthTimes=12;
	int  DayTimes=30;
	if (date.length()!=8 ) 
			{
		Log.logError("action－swipeDateDataHandle：传入的日期格式不合法请检查！",GetClassMethodName());		
			}
	else {
//		获得缺省的日期
		WebElement title  =appiumDriver.findElement(By.id("android:id/alertTitle"));			
		String textTitle=title.getText();	
		TestBase.assertion.webElementIsNotNull(title ,"判断日期控件标题是否为空",this.appiumDriver);
//		Log.logInfo("默认日期控件的标题为"+textTitle);
		
//		获得当前的日期的年月日  分别存储在三个变量中
		    SimpleDateFormat date1= new SimpleDateFormat("yyyyMMdd");
			String nowDate= date1.format(new Date());
			String day=(String) nowDate.subSequence(6, 8);
			String month=(String) nowDate.subSequence(4, 6);
			String year=(String) nowDate.subSequence(0,4);
       
//			比较年 月 日 大小，决定滑动方向
			int ykey=year.compareTo((String) date.subSequence(0,4));
			int mkey=month.compareTo((String) date.subSequence(4,6));
			int dkey=day.compareTo((String) date.subSequence(6,8));
			
//		得到年
		if (ykey>0)
		{
//			小于当前年向上翻
			getDate("0","0",(String) date.subSequence(0,4),YearTimes) ;
			
		}
		else if (ykey<0) {
//			大于当前年向下翻
			getDate("0","2",(String) date.subSequence(0,4),YearTimes) ;
			}
		else {
//			等于不翻页
			}

//			获得月
			if (mkey>0) {
				getDate("1","0",(String) date.subSequence(4,6),MonthTimes) ;
				
			}
			else if(mkey>0){
				getDate("1","2",(String) date.subSequence(4,6),MonthTimes) ;
			}
			else {
				
			}
//			获得日
			if (dkey>0) {
				getDate("2","0",(String) date.subSequence(6,8),DayTimes) ;
				
			}
			else if(dkey<0) {
				getDate("2","2",(String) date.subSequence(6,8),DayTimes) ;
			}
			else {
				
			}
			
//			点击完成按钮
			WebElement  complete =super.getElemntByYaml(Location.Button_Ptext, true, true, "完成", "");
		action.tap(complete, 500);
							
	}
	
	
}
/**获得选择日期列表的年月日
* 
* @param index  index属性 0代表年，1代表月 2代表日
* @param UpDown 上翻还是下翻，1代表点击上面的按钮，2代表点击下面的按钮
* @param toYear  目标日期
* @param times  翻页次数 年5次，月13  日30次
*/

public void  getDate(String index,String UpDown,String toYear,int times) 
	{	
	String singleMonth = null;
	if(times==12 && toYear.startsWith("0"))
	{   
		 singleMonth=(String) toYear.subSequence(1,2);	
	}
	else
	{
		
		singleMonth=toYear;
	}
	
	
		//根据参数选择上翻还是下翻日期
		WebElement cliceElement=super.getElemntByYaml(Location.NumberPickerButten_Index, true, true, index, UpDown);


//				修改等待时间
				appiumDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);		
		
			for (int i = 0; i < times; i++) 
			{				
			try 
				{	
			
			
//				定位目标日期是否出现
				    WebElement endelElement=appiumDriver.findElement(By.xpath("//android.widget.NumberPicker['"+index+"']/android.widget.EditText[starts-with(@text,'"+singleMonth+"')]"));
//				    Log.logInfo("第："+i+" 次点击找到:日期对象！");					 
//					回到默认等待时间
					appiumDriver.manage().timeouts().implicitlyWait(Config.implicitlyWaitTime, TimeUnit.SECONDS);
					break; 
				 }
				 catch (Exception e) 
				{
					 
//					 Log.logInfo("第："+i+" 次没找到对象！");	
					 cliceElement.click();
									
				}
			}
		
			
	}


 
/**
 * 选择下拉列表中的数据
 * @param caseNO  用例编号
 * @param ListName  写在配置文件中的下拉列表节点名，（如jiekuan）
 * @param xml     配置下拉列表信息xml对象，文件为在xmldata下
 * @param excle   配置下拉列表预期结果的字典excle对象，文件为在excelldata下
 */

public  static void  xialLaKuang(String caseNo,String ListName,XMLParase xml,ExcelReader excle)
{	
//	解析excle 后的下拉列表数据-预期结果
	ArrayList<String> dataList=null;
//	页面下拉选项集合-实际结果
	 List<WebElement>  elements=null;
//	 要选择的数据 对象
	 WebElement seletData=null;
//	 excle 的列名
	String columnName="";
//	 要选择的数据 名字
	String wantSele="";
//	多少条选择数据
	int dataSize=0;

	
	columnName=xml.getElementText("/*/"+ListName+"/columnName");
	wantSele=xml.getElementText("/*/"+ListName+"/wantSele");
	dataSize=DataHandle.getInt(xml.getElementText("/*/"+ListName+"/dataSize"));
	
	
//	获得excle 指定列的数据 到list对象
	dataList=DataHandle.getArryList(excle,dataSize,columnName);

	Log.logInfo(dataList.get(0)+"下拉列表数据需要数据的个数为："+dataList.size(),GetClassMethodName());
//	   获得标题
	WebElement 	title=getElemntByYaml(Location.TextView_Ptext, true, true, dataList.get(0),"");
//	TestBase.assertion.verifyEquals(caseNo, dataList.get(0), DataHandle.getElementText(title), "下拉框标题是否正确", appiumDriver);
//	   获得确定按钮
	WebElement  sure=getElemntByYaml(Location.Button_Ptext, true, true, "确定","");
//	TestBase.assertion.webElementIsNotNull(caseNo, sure,DataHandle.getElementText(title)+ "下拉框确认按钮是否存在", appiumDriver);

//	  获得取消按钮
	WebElement  canle=getElemntByYaml(Location.Button_Ptext, true, true, "确定","");
//	TestBase.assertion.webElementIsNotNull(caseNo, canle,DataHandle.getElementText(title)+ "下拉框取消按钮是否存在", appiumDriver);
	

	//得到下拉列表数据列表
	elements	= getElemnts(Location.ListViewCheckedTextViews_Pindex,"1","");
	
	

//	如果找到列表元素 遍历子数据，与excle中对比断言
	if(elements!=null)
	{
		try {

		int y=0;
			for (int i = 1; i <dataList.size(); i++) 
			{
//				数据从第1个开始	
//				TestBase.assertion.verifyEquals(caseNo,dataList.get(i), DataHandle.getElementText(elements.get(y)), "判断"+dataList.get(0)+"：下拉列表第"+(y+1)+"个数据", appiumDriver);	
				y++;
		 	}
		} catch (Exception e2) 
		{
			Log.logError("下拉列表索引错误，找不到对象！",GetClassMethodName());
		}

	}
	else {
		Log.logError("下拉列表数据没有定位到请检查定位器！",GetClassMethodName());
		}
	
//	找到要选择的数据
	seletData =  getElemntByYaml(Location.CheckedTextView_Ptext, true, true, wantSele,"");	
	if (seletData !=null) 
		{
			action.tap(seletData, 1000);
		}
		else
		{
			Log.logError(dataList+":下拉列表-找不到要选择的数据:"+wantSele,GetClassMethodName());
		}

	if (sure!=null) 
	{
		//点击确定按钮
		action.tap(sure, 500);
	}
	else 
	{
		Log.logError(dataList+":下拉列表-找不到确认按钮:",GetClassMethodName());
	}
				
}

/**
 * 处理筛选列表控件－差旅申请－分配编号
 * @param caseNo 用例编号
 * @param isAssert  是否要断言
 * @param title  标题名称
 * @param deafultString  搜索框默认文本
 * @param sedKey  输入的编码
 * @param wangSelectName  编码对应的字符串
 */
public  static void shuRuChaXun(String caseNo,boolean isAssert,String title,String deafultString,String sedKey,String wangSelectName)
{


//获得标题列
	WebElement titles=getElemntByYaml(Location.TextView_Ptext, true, true, title,"");

	//获得输入文本框
	WebElement inputText=getElemntByYaml(Location.EditText_Ptext, true, true, deafultString,"");
	if (isAssert) 
	{
//		TestBase.assertion.verifyEquals(caseNo,title,DataHandle.getElementText(titles), "判断"+title+"：筛选列表标题－", appiumDriver);
//		TestBase.assertion.verifyEquals(caseNo,deafultString,DataHandle.getElementText(inputText), "判断"+title+"：筛选列文本框默认值－", appiumDriver);
	
	
	}
	if (DataHandle.getElementText(inputText)!="无法定位元素") 
	{
		inputText.sendKeys(sedKey);
	}
	
	//获得搜索按钮
	WebElement search=getElemntByYaml(Location.TextView_Ptext, true, true, "搜索","");
	if (search!=null)
	{
		search.click();
	}
	//获得搜索结果
	WebElement resaust=getElemntByYaml(Location.TextView_Ptext, true, true, wangSelectName,"");
	
	if (DataHandle.getElementText(resaust)!="无法定位元素") 
	{
		resaust.click();
	}
if (isAssert) {
	TestBase.assertion.webElementIsNotNull(search, "判断搜索按钮是否存在", appiumDriver);
	TestBase.assertion.webElementIsNotNull( resaust, "判断搜索数据是否被搜索到", appiumDriver);
}	
}



/**
 * 获得弹窗对象
 * @param NO  用例编号
 * @param param  数据驱动对象
 * @param selectName   弹窗名字，用于日志输出
 * 
 */
public void  taChuanChuLi(String NO,Map<String, String> param,String selectName )
{
 ArrayList<String> Object =DataHandle.changeToArry(param);
 
WebElement title=super.getElemntByYaml(Location.TextView_Ptext, true, true, Object.get(0),"");

//TestBase.assertion.verifyEquals(NO,Object.get(0), title.getText(), "判断"+selectName+"：单选框标题－标题", appiumDriver);

WebElement agree=super.getElemntByYaml(Location.TextView_Ptext, true, true, Object.get(1),"");
WebElement agreeImage=super.getElemntByYaml(Location.TextView_Ptext, true, true, "4","");
//TestBase.assertion.verifyEquals(NO,Object.get(1), agree.getText(), "判断"+selectName+"：同意按钮标题－", appiumDriver);
TestBase.assertion.webElementIsNotNull( agreeImage, "同意按钮图标", appiumDriver);

WebElement disAgree=super.getElemntByYaml(Location.TextView_Ptext, true, true, Object.get(2),"");
WebElement disagreeImage=super.getElemntByYaml(Location.TextView_Ptext, true, true, "6","");
//TestBase.assertion.verifyEquals(NO,Object.get(1), disagreeImage.getText(), "判断"+selectName+"：拒绝按钮标题－", appiumDriver);
//TestBase.assertion.verifyEquals(NO,Object.get(2), disAgree.getText(), "判断"+selectName+"：拒绝按钮－", appiumDriver);

WebElement oppions=super.getElemntByYaml(Location.TextView_Ptext, true, true, Object.get(3),"");
//TestBase.assertion.verifyEquals(NO,Object.get(3), oppions.getText(), "判断"+selectName+"：审批意见文本框－", appiumDriver);


WebElement commit=super.getElemntByYaml(Location.Button_Ptext, true, true, Object.get(4),"");
//TestBase.assertion.verifyEquals(NO,Object.get(4), oppions.getText(), "判断"+selectName+"：提交按钮－", appiumDriver);
//返回
action.pressKeyCode(KeyEvent.fanHui);
}

/**
* 通用界面的审批如费用报销
* @param caseNo  用例编号
* @param agree  是否同意
* @param message  拒绝原因
*/
public static void  shenPiTongYong(String caseNo,Boolean agree,String message)
{
if (agree) 
{
	WebElement agreeButten=getElemntByYaml(Location.TextView_Ptext, true, true, "同意","");
//	TestBase.assertion.verifyEquals(caseNo,  "同意", DataHandle.getElementText(agreeButten),"同意按钮是否存在", appiumDriver);
	action.tap(agreeButten, 300);	
}
else
{
//	退回按钮
	WebElement disAgre=getElemntByYaml(Location.TextView_Ptext, true, true, "退回", "");
	action.tap(disAgre, 300);
	
	WebElement title=getElemntByYaml(Location.TextView_Ptext, true, true, "请输入审批意见", "");
	WebElement options=getElemntByYaml(Location.id, true, true, "cn.cooperative:id/et_opinion", "");
	WebElement sure=getElemntByYaml(Location.Button_Ptext, true, true, "确定", "");
	WebElement cancle=getElemntByYaml(Location.Button_Ptext, true, true, "取消", "");
	
	TestBase.assertion.webElementIsNotNull( title, "判断退回弹窗标题存在", appiumDriver);
	TestBase.assertion.webElementIsNotNull( options, "判断退回原因存在", appiumDriver);
	TestBase.assertion.webElementIsNotNull( sure, "判断确定按钮是否存在", appiumDriver);
	TestBase.assertion.webElementIsNotNull( cancle, "判断取消按钮是否存在", appiumDriver);
	
	action.sendKey(options, message);
	action.tap(sure, 1000);
}

}


}
