package com.Pcitc.AppAutomationTest.base;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dom4j.Element;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.Pcitc.AppAutomationTest.pagesHelper.Config;
import com.Pcitc.AppAutomationTest.pagesHelper.PageFuntion;
import com.Pcitc.AppAutomationTest.pagesHelper.TestInit;
import com.Pcitc.AppAutomationTest.utils.Action;
import com.Pcitc.AppAutomationTest.utils.Assertion;
import com.Pcitc.AppAutomationTest.utils.Color;
import com.Pcitc.AppAutomationTest.utils.ConnectMySQL;
import com.Pcitc.AppAutomationTest.utils.Driver;
import com.Pcitc.AppAutomationTest.utils.Log;
import com.Pcitc.AppAutomationTest.utils.ExcelHandle;
import com.Pcitc.AppAutomationTest.utils.ExcelReader;
import com.Pcitc.AppAutomationTest.utils.FindWebElement;
import com.Pcitc.AppAutomationTest.utils.GetClassMethodName;
import com.Pcitc.AppAutomationTest.utils.Log;
import com.Pcitc.AppAutomationTest.utils.ParseYamlFile;
import com.Pcitc.AppAutomationTest.utils.ScreenShots;
import com.Pcitc.AppAutomationTest.utils.TimeString;
import com.Pcitc.AppAutomationTest.utils.XMLParase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import jxl.write.WriteException;
import sun.util.logging.resources.logging;

/**
 * Funtion ：页面对象的获取 数据的递归判断 数据驱动
 * @author Administrator
 *
 */
public class TestBase  extends  GetClassMethodName
{
	public static boolean isGenReport=false;
//	测试开始时间，beforsuit赋值
	public static String startTime="";
//	测试结束时间，aftersuit赋值
	public static String endTime="";
//	测试耗时，beforsuit赋值
	public static String useTime="";
	
//	总共的用例数据，在用例方法前执行，调用testbase的beformethod自动赋值
	public static int totalTestCase=0;
//	通过的用例数据，在用例方法最后一行执行，调用testbase的afterMethod自动赋值
	public static int passTestCase=0;
//	失败的用例数据，在用例方法的cathc执行，以及调用pagefuntion的exceptionLogOutAndroid自动赋值
	public static int failTestCase=0;
	
//	致命错误的个数，执行log类中的logDeadly自动赋值
	public static int deadlyNo=0;
//	严重错误的个数，执行log类中的logerror自动赋值
	public static int seriousNo=0;
//	断言失败或者找不到对象个数，执行log类中的logwaring自动赋值
	public static int commonlyNo=0;
	/**
	 * 当前模块总用例数
	 */
	public static int modelTotal=0;
	/**
	 * 当前总断言数
	 */
	public static int modelTotalAsser=0;
	/**
	 * 当前模块失败用例数
	 */
	public static int modelStop=0;
	/**
	 * 当前模块断言失败数
	 */
	public static int modelAsserFail=0;
//	是否停止运行
	public static boolean StopRun =false;
//	是否停止运行
	public static  ArrayList<String> ErrorList;
//	驱动
	public static AppiumDriver<WebElement> appiumDriver;
//	获得action
	public static Action action=null;
//	测试用例编号
	public static String testCaseNo="";
//	安卓定位相关字符串
	protected final String AndroidTitleLocatType="Android字段定位方式";
	protected final String AndroidTitleLocatString="Android字段定位器";
	protected final String AndroidDataLocatType="Android数据定位方式";
	protected final String AndroidDataLocatString="Android数据定位器";
	
//	ios定位相关字符串
	protected final String IosTitleLocatType="Ios字段定位方式";
	protected final String IosTitleLocatString="Ios字段定位器";
	protected final String IosDataLocatType="Ios数据定位方式";
	protected final String IosDataLocatString="Ios数据定位器";
//	断言方法输入日志信息
	protected final String Field="字段";
	protected final String FieldData="数据";
//	excle相关对象
//	读取测试数据唯一标识文件
	protected static ExcelHandle eh=null;
//	插入测试报告文件及索引
	public static  ExcelHandle reportExcleExcelHandle=null;
	public static  int reportExcleExcelRow=1;
//  读取测试生成数据excle文件
	protected static ExcelReader GenDataExcle=null ;
//	读取页面定位excle 用于定位元素 断言日志输出 读取测试数据 选择下拉数据等
	public 	static ExcelReader PageElmentExcle=null ;
	public static int PageElmentExcleIndex=1 ;
//	测试用例类获取excle数据索引
	public static int TestCaseElmentExcleIndex=1 ;
//	excle文件定位页面元素
	public static  FindWebElement findWebElement=null;
//	判断当前是否已经获取yaml
	public static Boolean isGetyamlpath=false;
//	封装yaml文件对象
	protected static   ParseYamlFile parseYamlFile=null;
//	截图
	public static ScreenShots screenShots=null;	
//	获得assrtion
	public static  Assertion assertion=null ;
//	xml解析对象数据驱动
	private static  XMLParase   xmlParase;
//	读取xml文件
	protected static XMLParase 	xml=null ;
//	封装xml文件的数据
	private Map<String, String> commonMap;
//	mysal对象
	public static ConnectMySQL mySql;
//	点击服务按钮
	protected static   Screen screen ;

	/**
	 * 构造函数初始化对象
	 * @param driveType  
	 */
 public void  getDriver() 
 { 
//	 初始化错误信息列表
	 ErrorList=new ArrayList<String>();
	 
//	 获得driver对象
	 Driver  driver = new 	Driver();
	 driver.getDriver();
	 appiumDriver=driver.driver;
	 
	 Log.logInfo("appiumDriver获取成功",GetClassMethodName());
//	 创建action 对象
	 action=new Action(appiumDriver);
	 Log.logInfo("action创建成功",GetClassMethodName());
	 
//	 获得截图对象
	 assertion=new Assertion();
	 Log.logInfo("assertion创建成功",GetClassMethodName());
	 
//	 获得屏幕截图对象
	 screenShots=new ScreenShots(appiumDriver);
	 Log.logInfo("screenShots创建成功",GetClassMethodName());
	 
//	 excel定位元素
	 findWebElement=new FindWebElement(appiumDriver);
	 Log.logInfo("findWebElement创建成功",GetClassMethodName());
	 
//	 获得 parseYamlFile对象
	 parseYamlFile=new ParseYamlFile(appiumDriver);	 
	 Log.logInfo("parseYamlFile创建成功",GetClassMethodName());
	
	 eh=new ExcelHandle();	
	 initGenDataExcle();
	 Log.logInfo("测试生成数据初始化成功",GetClassMethodName());
	 
	 reportExcleExcelHandle=new ExcelHandle();
	 Log.logInfo("测试报告excle初始化成功",GetClassMethodName());
	 
	 screen =new Screen();
	 Log.logInfo("screen创建成功",GetClassMethodName());

//		 链接数据库
//		 mySql= new ConnectMySQL();			
//		 mySql.connect("localhost:3306/XY", "root", "fu~123");
//		 Log.logInfo("mySql创建成功",GetClassMethodName());
	 
}
 static String nowRunClass="";
 
 public static void GenExcleModelReport(int row,String nowClass)
 {
//	 判断当前类是否与参数一致，如果一致不生成报告
	if (nowClass.equals(nowRunClass) ) 
	{
		
	}
	else 
	{
//		为默认时候
		if (nowRunClass.equals(""))
		{
			Log.logInfo("init通过，插入测试报告", GetClassMethodName());
			row=7;
		}
		Log.logInfo("当前模块执行完毕，插入测试报告", GetClassMethodName());
		nowRunClass =nowClass;
		TestBase.reportExcleExcelHandle.updateFile("./target/surefire-reports/html/测试报告.xls", "");
		
		TestBase.reportExcleExcelHandle.updateSheet("概要信息");	
		
		TestBase.reportExcleExcelHandle.addCellDataWithColor(row, 1,Integer.toString(modelTotal), Color.heise, Color.lvse);
		TestBase.reportExcleExcelHandle.addCellDataWithColor(row, 2,Integer.toString(modelTotal-modelStop), Color.heise, Color.lvse);
		TestBase.reportExcleExcelHandle.addCellDataWithColor(row, 3,Integer.toString(modelStop), Color.heise, Color.hongse);
		TestBase.reportExcleExcelHandle.addCellDataWithColor(row, 4,Integer.toString(modelAsserFail), Color.heise, Color.huangse);
		TestBase.reportExcleExcelHandle.addCellDataWithColor(row, 5,Integer.toString(modelTotalAsser), Color.heise, Color.lvse);
		TestBase.reportExcleExcelHandle.afterExcle();
		Log.logInfo("当前测试类结果已经插入excleReport中", GetClassMethodName());
//		重置
		modelTotal=0;
		modelTotalAsser=0;
		modelStop=0;
		modelAsserFail=0;
	}
		
 }
 public static void GenExcleDetailsReport()
 {
	 if (TestInit.IsAndroid)
	 {
//			获得测试结束时间及耗时
			endTime=TimeString.getyMDHMS();
			useTime=TimeString.timeMinus(endTime,startTime);
			TestBase.reportExcleExcelHandle.updateFile("./target/surefire-reports/html/测试报告.xls", "");
			TestBase.reportExcleExcelHandle.updateSheet("概要信息");	
//			信息列插入开始时间
			TestBase.reportExcleExcelHandle.addCellDataWithColor(0, 1,startTime, Color.heise, Color.lvse);
//			信息列插入结束时间
			TestBase.reportExcleExcelHandle.addCellDataWithColor(0, 3,endTime, Color.heise, Color.lvse);
//			信息列插入耗时
			TestBase.reportExcleExcelHandle.addCellDataWithColor(0, 5,useTime, Color.heise, Color.lvse);

//			用例执个数
			TestBase.reportExcleExcelHandle.addCellDataWithColor(1, 1,Integer.toString(totalTestCase), Color.heise, Color.lvse);
//			成功数
			TestBase.reportExcleExcelHandle.addCellDataWithColor(1, 3, Integer.toString(totalTestCase-failTestCase), Color.heise, Color.lvse);
//			失败数
			TestBase.reportExcleExcelHandle.addCellDataWithColor(1, 5, Integer.toString(failTestCase), Color.heise, Color.hongse);

//			致命错误数
			TestBase.reportExcleExcelHandle.addCellDataWithColor(2, 1, Integer.toString(deadlyNo), Color.heise, Color.shenhongse);
//			严重错误数
			TestBase.reportExcleExcelHandle.addCellDataWithColor(2, 3, Integer.toString(seriousNo), Color.heise, Color.hongse);
//			断言失败错误数
			TestBase.reportExcleExcelHandle.addCellDataWithColor(2, 5, Integer.toString(commonlyNo), Color.heise, Color.huangse);

			TestBase.reportExcleExcelHandle.afterExcle();
			
			Log.logInfo("自动化报告生成",GetClassMethodName());
			
			appiumDriver.quit();
			appiumDriver=null;
			isGenReport=true;
	}
else {
//	获得测试结束时间及耗时
	endTime=TimeString.getyMDHMS();
	useTime=TimeString.timeMinus(endTime,startTime);
	TestBase.reportExcleExcelHandle.updateFile("./target/surefire-reports/html/测试报告.xls", "");
	TestBase.reportExcleExcelHandle.updateSheet("概要信息");	
//	信息列插入开始时间
	TestBase.reportExcleExcelHandle.addCellDataWithColor(3, 1,startTime, Color.heise, Color.lvse);
//	信息列插入结束时间
	TestBase.reportExcleExcelHandle.addCellDataWithColor(3, 3,endTime, Color.heise, Color.lvse);
//	信息列插入耗时
	TestBase.reportExcleExcelHandle.addCellDataWithColor(3, 5,useTime, Color.heise, Color.lvse);

//	用例执个数
	TestBase.reportExcleExcelHandle.addCellDataWithColor(4, 1,Integer.toString(totalTestCase), Color.heise, Color.lvse);
//	成功数
	TestBase.reportExcleExcelHandle.addCellDataWithColor(4, 3, Integer.toString(totalTestCase-failTestCase), Color.heise, Color.lvse);
//	失败数
	TestBase.reportExcleExcelHandle.addCellDataWithColor(4, 5, Integer.toString(failTestCase), Color.heise, Color.hongse);

//	致命错误数
	TestBase.reportExcleExcelHandle.addCellDataWithColor(5, 1, Integer.toString(deadlyNo), Color.heise, Color.shenhongse);
//	严重错误数
	TestBase.reportExcleExcelHandle.addCellDataWithColor(5, 3, Integer.toString(seriousNo), Color.heise, Color.hongse);
//	断言失败错误数
	TestBase.reportExcleExcelHandle.addCellDataWithColor(5, 5, Integer.toString(commonlyNo), Color.heise, Color.huangse);

	TestBase.reportExcleExcelHandle.afterExcle();
	
	Log.logInfo("自动化报告生成",GetClassMethodName());
	appiumDriver.quit();
	appiumDriver=null;
}
}
 /**
  * 初始化定位器yaml文件
  * @param modeClassName
  */
public void beforeClass()
 {
//	获得默认yaml
	getBeforeElement("公共页面元素");
	Log.logInfo("yaml文件:公共页面元素,已加载",GetClassMethodName());
 }
/**
 * 生成模块测试报告
 * @param row
 */
public void afterClass(int row,String className)
{
GenExcleModelReport(row ,className);
}

/**
 * testcase使用，获得页面定位 断言 及数据的excle对象
 * @param modeClassName
 * @param modeMethodName
 */
String nowMethod="";
public void beforeMethod(String modeClassName,String modeMethodName)
{
modelTotal++;
totalTestCase++;
if (modeClassName!="") 
{
	PageElmentExcle = getExcle(modeClassName, modeMethodName);
	Log.logInfo("PageElmentExcle初始化完毕！file:"+modeClassName+"xls,sheet:"+MethodeName, GetClassMethodName());
}

}
//用例类方法后执行， 增加成功
protected void afterMethod(int row,String className)
{

	if (StopRun) 
	{
	Log.logInfo("发生严重错误，当前用例执行后通知测试", GetClassMethodName());
	GenExcleModelReport(row,className);
	GenExcleDetailsReport();	
	Log.logInfo("发生致命错误，自动化报告生成,停止自动化测试",GetClassMethodName());
	appiumDriver.quit();
	appiumDriver=null;
	}
}
/**
 * 页面类在定位前执行
 * @param yamlname  yaml文件名称
 */
protected  static void getBeforeElement (String yamlname) 
{
	 getYamlFile(getYamlPath(yamlname));
}




	/**
	 * 获得登陆用户名
	 * @param modeName 模块名，如“gongshi”
	 * @param leavle 第几级审批人如“1”
	 * @return
	 */
	protected String getUserName(String modeName,String leavle)
	{
//		读取AppUser.xml 文件的配置用户名 密码
		xml=new XMLParase(Config.xmlLib+"AppUser.xml");
		String useNameString=""; 
			if (TestInit.IsTestEnvirectory) {
				
				 useNameString =xml.getElementText("/*/ceshi/"+modeName+"L"+leavle+"User");
			}
			else {
				 useNameString =xml.getElementText("/*/zhengshi/"+modeName+"L"+leavle+"User");
			}
		
		Log.logInfo("登陆用户名为："+useNameString,GetClassMethodName());
		return useNameString;
	}
	
	/**
	 * 获得登陆用户密码
	 * @param modeName 模块名，如“gongshi”
	 * @param leavle 第几级审批人如“1”
	 * @return
	 */
		protected String getUserPassWord(String modeName,String leavle)
		{

			String passWord=""; 
				if (TestInit.IsTestEnvirectory) {
					passWord =xml.getElementText("/*/ceshi/"+modeName+"L"+leavle+"Password");
				}
				else {
					passWord =xml.getElementText("/*/zhengshi/"+modeName+"L"+leavle+"Password");
				}
			
			Log.logInfo("登陆密码为："+passWord,GetClassMethodName());
			return passWord;
					
		}
	
	/**
	 * 移动端生成的数据存入文件中
	 * @param GenData 要存的数据
	 * @param row 行号 （从 0开始）
	 * @param column 列号
	 */
	protected void genDatainsertExcleData(String GenData,int row,int column)
	{
	
		eh.updateFile("./File/dataExcles/测试数据.xls", "./File/dataExcles/测试数据.xls");
		//如果两个参数不一致，执行后会生成一个新文件为参数二，与参数1文件相同；如修改cell值只对新生成的附件起作用
		if (TestInit.IsTestEnvirectory)
		{
			eh.updateSheet("测试环境");
		}
		else {
			eh.updateSheet("正式环境");
			}
	
		eh.addCellData(row, column, GenData);
		
//		保存生效配置
	
		eh.afterExcle();
			
		Log.logInfo("安卓-差旅申请生成数据："+GenData+"已存入文件：./File/dataExcles/测试数据.xls",GetClassMethodName());
	
		
	}

	
	/**
	 * 获得生成测试数据文件中的指定数据
	 * @param row 行号 如1
	 * @param columnName 列名 如“费用报销”
	 * @return
	 */
	protected  String getGenDataExcleData(int row,String columnName ) 
	{
//		返回测试数据
		return GenDataExcle.getCellData(row, columnName);
	}

	/**初始化测试数据excle文件,
	 * 
	 */
	protected  void initGenDataExcle() 
	{
//		Log.logInfo("拷贝pc生成数据到："+Config.excleLib+"测试数据.xls",GetClassMethodName());
//		eh.updateFile("/project/eclipse/WebTest/ExcelData/PC端生成的数据.xls", Config.excleLib+"测试数据.xls");
//		eh.afterExcle();
		//Log.logInfo("最新测试数据已覆盖到："+Config.excleLib+"测试数据.xls",GetClassMethodName());
		
//		判断环境指定sheetname
		if (TestInit.IsTestEnvirectory) 
		{
			GenDataExcle =getExcle("测试数据", "测试环境");
	
		}
		else {
			GenDataExcle =getExcle("测试数据", "正式环境");
			
		}
	
	}

	/**
	 * 更改页面元素显示等待时间为默认
	 */
	
	protected static  void changWaitTimeToDefault()
	{
		ParseYamlFile.waitTime=Config.ElementWaitTime;
		Config.ElementWaitTime=5;
	}

	/**
	 * 更改页面元素显示等待时间
	 */
	protected static  void changWaitTimeToVar(int time)
	{
		ParseYamlFile.waitTime=time;
		Config.ElementWaitTime=time;
	}
	
	 
/**
 * 得到sql查询结果
 * @param selectSql
 * @return
 */
	 public  static  List<HashMap<String, String>> getSqlSelect (String selectSql)
	 {
		 List<HashMap<String, String>>  res= ConnectMySQL.getSqlResault(selectSql, true);
		return res;
	 }
//	 执行sql更新语句
	 public  static  void getSqlUpdate (String selectSql)
	 {
		mySql.getSqlResault(selectSql, false);	
	 }
	
	 	/**
		 * 得到Excle对象
		 * @param fileName  文件名称（没有扩展名）
		 * @param sheetName sheet名
		 *  @return Excle对象
		 */
		
public  static  ExcelReader getExcle (String fileName , String sheetName)
		 {
		
			ExcelReader excle= new ExcelReader(fileName,sheetName);
			return excle;
		 }
		

/**
		 * 获得xml对象
		 * @param fileName 文件名（只是文件名）
		 * @return
		 */
		public  static XMLParase getXml  (String fileName)
		 {

			Log.logInfo("xml文件地址："+Config.xmlLib+fileName,GetClassMethodName());
			xml= new XMLParase(Config.xmlLib+fileName);
			return xml;
		
			
		 }
	
		
			/**
			 * 得到yaml文件的据对路径
			 * @param fileName  文件名称（没有扩展名）
			 * @return
			 */
		public  static String getYamlPath(String fileName)
		 {
			 String ElmentFilePath=String.format(Config.yamlLib+"%s"+".yaml",fileName);
			 Log.logInfo("yaml路径获取成功，路径-"+ElmentFilePath,GetClassMethodName());
			 return ElmentFilePath;
		 }
//		 @Test(description="测试路径写法")
		 public void t2()
		 {
			Log.logInfo(this.getYamlPath("class"),GetClassMethodName()); 
		 }
	 
	/**
	 * 获得yaml文件路径用于定位元素
	 * @param yamlpath yaml文件路径，获得webelemnt对象前调用此方法
	 * 
	 */
	 public static void getYamlFile(String yamlpath)
	{
		try {
			parseYamlFile.getYamlFile(yamlpath);
			isGetyamlpath=true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Log.logError("yaml 文件没找到",GetClassMethodName());
			e.printStackTrace();
		}
	}
	 
	/**
	 * 使用 excle文件获取对象
	 * @param ex excle对想
	 * @param wait 是否等待元素出现
	 * @param byTypeColumn 定位方式
	 * @param locatStringcolumn 定位器
	 * @return
	 */
		protected static    WebElement  getElemntByExcle(ExcelReader ex,boolean wait,String byTypeColumn,String locatStringcolumn)
		{
			if (wait) 
			{
			return	findWebElement.getElementWait(ex, byTypeColumn, locatStringcolumn);
			}
			else
			{
			return	findWebElement.getElementNoWait(ex, byTypeColumn, locatStringcolumn);
			}

		}

		/**
 	* 得到页面WebElement元素
 * @param element：yaml文件元素名称
 * @param wait 是否要等待
 * @param replace 是否要替换
 * @param a 替换前字符
 * @param b 替换后字符
 * @returnc
 */
	protected static    WebElement  getElemntByYaml(String element,Boolean wait, Boolean replace,String a,String b)
	{
		if (wait)
		{
			if(replace)
				{
					return parseYamlFile.getElementWaitReplace(element, a, b );
				}
			else
				{
					return parseYamlFile.getElementWaitNOReplace(element);
				}
		}
		else
		{
			
				if(replace)
				{
					return parseYamlFile.getElementNoWaitReplace(element, a, b);
				}
				else
				{
					return parseYamlFile.getElementNoWaitNOReplace(element);
				}
			}
		}
	
	/**
	 * 得到WebElements 对象
	 * @param elementName  定位器名称
	 * @param a 替换参数1
	 * @param b  替换参数2
	 * @return
	 */	
	protected static   List<WebElement> getElementsByYaml (String elementName,String a,String b)
	{
		return parseYamlFile.getElemens(elementName,a,b);
	}
	
	
	
	
	
	
// 数据驱动区域
	
	// 数据驱动区域
		/**XML数据驱动
		 * 初始化xmlParase用与使用xml做数据驱动，类名要和xml的文件吗一致
		 */
		private void initialPx()
		{
			String path="./XmlData/"+this.getClass().getSimpleName()+".xml";
			if(xmlParase==null)
			{
				try{
					
				xmlParase=new XMLParase(path);
				}
				catch(Exception e)
				{
					Log.logError(e.toString(), GetClassMethodName());
//					Log.logError("class：testbase－method：initialPx：XML文件不存在，请检查路径！" +path);
					
				}
			}
			
		}
		/** 公用节点数据
		 * 
		 */
		private void getCommonMap()
		{
			if(commonMap==null)
			{
				Element element= xmlParase.getElementObject("/*/common");
				commonMap = xmlParase.getChildrenInfoByElement(element);
			}
		}
		/**
		 * xml 数据驱动封装
		 * @param method
		 * @return
		 */
		@DataProvider(name="xml")
		public Object[][] providerMethod(Method method)
		{
//			初始化  commonMap、xmlParase对象
			this.initialPx();
			this.getCommonMap();
//			获得调用类的方法名
		String methodName = method.getName();
//		获得与方法名 同名节点下的数据集合
		List<Element> elements=xmlParase.getElementObjects("/*/"+methodName);
//		创建 object对象,依次遍历elements的子数据
		Object[][] object= new Object[elements.size()][];
		for(int i=elements.size()-1;i>-1;i--)
		{
		Map<String, String>	 mergeCommon =this.getMergeMapData(xmlParase.getChildrenInfoByElement(elements.get(i)), commonMap);
		Map<String, String>	 mergeGlobal =this.getMergeMapData(mergeCommon,com.Pcitc.AppAutomationTest.utils.Global.global);
		Object[] temp=new Object[]{mergeGlobal};
		object[i]=temp;
		}
		return object;
		}
		/** 
		 * 获得xml叶节点数据
		 * @param map1
		 * @param map2
		 * @return
		 */
		private Map<String, String>	getMergeMapData(Map<String, String> map1,Map<String,String> map2)
		{
		Iterator<String> it = map2.keySet().iterator();
		while(it.hasNext())
			{
				String key =it.next();
				String value=map2.get(key);
				if(!map1.containsKey(key))
				{
					map1.put(key, value);
				}
			}
		return map1;
		}
	
	
	/**
	 * mysql 数据驱动封装，只能用于测试用例类中
	 * @param method
	 * @return
	 */
	 protected ConnectMySQL mysql=null;
	 XMLParase xmlparase=null;
		@DataProvider(name="Mysql")	
		  public Object[][] mysqlDp(Method method) 
		 {
			
//			获得类名
			String Class="./MysqlData/"+this.getClass().getSimpleName()+".xml";
//			获得调用类的方法名
			String methodName = method.getName();
			Object[][] uu=null;
			return uu=ConnectMySql(Class,methodName) ;

		    }
	
		 public Object[][] ConnectMySql(String Class,String MethodName) 
		 {	
			 
			
				
				 try {
					 xmlparase=new XMLParase(Class);	
				} catch (Exception e) {
					Log.logError("mysqlxml文件配置错误请检查",GetClassMethodName());
				}
				 
					
//	数据库链接名称
					String DataBase=xmlparase.getElementText("/*/DataBase");
//用户名
					String UserName=xmlparase.getElementText("/*/UserName");
//密码
					String PassWord=xmlparase.getElementText("/*/PassWord");
//					获得sql语句
					String Sql=xmlparase.getElementText("/*/"+MethodName);
//					System.out.println(DataBase+UserName+PassWord);
			 mysql= new ConnectMySQL();		
			 mysql.connect(DataBase, UserName, PassWord);
			 Object a[][]=ConnectMySQL.getObjectData(Sql);
			 	return a;
//			 List<HashMap<String, String>> rs = ConnectMySQL.query(Sql);
//			 System.out.println(rs.get(0));
		 }
		 
//	 @Test(dataProvider="Mysql")
	 /**
	  * 测试数据驱动,sql查询结果有几列就要有几个参数，有几行就会执行几遍
	  * @param a 第一列的别名
	  * @param b第二列的别名
	  * @param c第三列的别名
	  */
	  public  void msqltest(String a,String b,String c)
	 {
						 System.out.println(a);
						 System.out.println(b);
						 System.out.println(c);
						
					
	 }
	  /***
	   * excel 数据驱动
	   * @param method 调用方法的方法名
	   * @return 
	   */
	  @DataProvider(name="excle")	
		public Object[][] ecxel(Method method)
		{
//		  获得调用类的类名，也就是excel文件地址
		  this.excelInt();
//		  获得调用类的方法名，也就是sheet名
		  String methodName = method.getName();

//		  读取excel得到object[][]对象
		  try {
			  ExcelReader Excelreader = new ExcelReader(this.excelpath,methodName);
				Excelreader.getCellData(1, 1); 
				Object[][] object= new Object[Excelreader.getMapData.size()][];
				 for (int i=0; i < Excelreader.getMapData.size(); i++) 
			{
			Map<String, String>	 map =Excelreader.getMapData.get(i);
			
			Object[] temp=new Object[]{map};
			object[i]=temp;
			}
			return object;
		} catch (Exception e) {
			e.printStackTrace();
			Log.logError(e.toString(),GetClassMethodName());
			return null;
		}
		  
		}
		String excelpath="";		
	  public  void excelInt()
		{
//			获得excel文件
			excelpath=this.getClass().getSimpleName();			
				
			
		}

}
