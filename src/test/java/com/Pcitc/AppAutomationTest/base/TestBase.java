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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.pagesHelper.Config;
import com.Pcitc.AppAutomationTest.pagesHelper.TestInit;
import com.Pcitc.AppAutomationTest.utils.Action;
import com.Pcitc.AppAutomationTest.utils.Assertion;
import com.Pcitc.AppAutomationTest.utils.ConnectMySQL;
import com.Pcitc.AppAutomationTest.utils.Driver;
import com.Pcitc.AppAutomationTest.utils.ErrorLog;
import com.Pcitc.AppAutomationTest.utils.ExcelHandle;
import com.Pcitc.AppAutomationTest.utils.ExcelReader;
import com.Pcitc.AppAutomationTest.utils.GetClassMethodName;
import com.Pcitc.AppAutomationTest.utils.Log;
import com.Pcitc.AppAutomationTest.utils.ParseYamlFile;
import com.Pcitc.AppAutomationTest.utils.ScreenShots;
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
//	判断当前是否已经获取yaml
	 public static Boolean isGetyamlpath=false;
//	截图
	public static ScreenShots screenShots=null;	
//	mysal对象
	public static ConnectMySQL mySql;
	public ArrayList<String> titleName=null;
//	xml解析对象数据驱动
	private static  XMLParase   xmlParase;

//	封装xml文件的数据
	private Map<String, String> commonMap;
//	驱动
	public static AppiumDriver<WebElement> appiumDriver;
	
//	获得action
	public static Action action=null;
//	获得assrtion
	public static  Assertion assertion=null ;
//	封装yaml文件对象
	protected static   ParseYamlFile parseYamlFile=null;
//	点击服务按钮
	protected static   Screen screen ;
//	读取生成测试数据的-excle文件 全局的初始化执行一次
	protected static ExcelReader GenDataExcle=null ;
//	读取页面定位 修改页面 的-excle文件 page类中初始化
	protected 		 ExcelReader PageDataExcle=null ;
//	读取页面定位 修改页面 的-excle文件 页面弹窗对象，在testcase中初始化
	protected 		 ExcelReader AlertDataExcle=null ;
//	读取页面定位 修改页面 的-excle文件 数据驱动 填充表单信息
	protected 		 ExcelReader FixDataExcle=null ;
	protected final String  FixDataExcleSheet="选择数据";
	protected final String  PageDataExcleSheet="默认页面";
	protected final String  AlertDataExcleSheet="弹出页面";
//	读取测试数据唯一标识文件
	protected static ExcelHandle eh=null;
	
//	读取xml文件
	protected static XMLParase 	xml=null ;
	
	/**
	 * 构造函数初始化对象
	 * @param driveType  
	 */
 public void  getDriver() 
 {
//	 获得driver对象
	 Driver  driver = new 	Driver();
	 driver.getDriver();
	 appiumDriver=driver.getDriver2();

//	 获得截图对象
	 assertion=new Assertion();
//	 获得屏幕截图对象
	 screenShots=new ScreenShots(appiumDriver);
//	 获得 parseYamlFile对象
	 parseYamlFile=new ParseYamlFile(appiumDriver);
	 if (parseYamlFile!=null)
	 {
		Log.logInfo("parseYamlFile创建成功"+GetClassMethodName());
	}
//	 创建action 对象
	 action=new Action();
	 Log.logInfo("action创建成功"+GetClassMethodName());
	
	 eh=new ExcelHandle();
	 Log.logInfo("测试生成数据ExcelHandle初始化成功"+GetClassMethodName());
	 
//		判断环境指定sheetname
		initGenDataExcle();
	
		 
	
//		 链接数据库
//		 mySql= new ConnectMySQL();			
//		 mySql.connect("localhost:3306/XY", "root", "fu~123");
}

   
	/**
	 * 获得登陆用户名
	 * @param modeName 模块名，如“gongshi”
	 * @param leavle 第几级审批人如“1”
	 * @return
	 */
	//获得用户名
	protected String getUserName(String modeName,String leavle)
	{
		
		String useNameString=""; 
			if (TestInit.IsTestEnvirectory) {
				 useNameString =Config.xm.getElementText("/*/ceshi/"+modeName+"L"+leavle+"User");
			}
			else {
				 useNameString =Config.xm.getElementText("/*/zhengshi/"+modeName+"L"+leavle+"User");
			}
		
		Log.logInfo("登陆用户名为："+useNameString);
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
					passWord =Config.xm.getElementText("/*/ceshi/"+modeName+"L"+leavle+"Password");
				}
				else {
					passWord =Config.xm.getElementText("/*/zhengshi/"+modeName+"L"+leavle+"Password");
				}
			
			Log.logInfo("登陆密码为："+passWord);
			return passWord;
					
		}
	/**
	 * 移动端生成的数据存入文件中
	 * @param GenData 要存的数据
	 * @param row 行号 
	 * @param column 列号
	 */
	protected void genDatainsertExcleData(String GenData,int row,int column)
	{
	
		eh.updateFile("./ExcelData/测试数据.xls", "./ExcelData/测试数据.xls");
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

		
		Log.logInfo("安卓-差旅申请生成数据："+GenData+"已存入文件：./ExcelData/测试数据.xls");
	
		
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

		Log.logInfo("拷贝pc生成数据到："+Config.excleLib+"测试数据.xls",GetClassMethodName());
		eh.updateFile("/project/eclipse/WebTest/ExcelData/PC端生成的数据.xls", Config.excleLib+"测试数据.xls");
		eh.afterExcle();
		Log.logInfo("最新测试数据已覆盖完成！",GetClassMethodName());
		
//		判断环境指定sheetname
		if (TestInit.IsTestEnvirectory) 
		{
			GenDataExcle =getExcle("测试数据.xls", "测试环境");
	
		}
		else {
			GenDataExcle =getExcle("测试数据.xls", "正式环境");
			
		}
	
	}
	/**
	 * 更改页面元素显示等待时间为默认
	 */
	protected static  void changWaitTimeToDefault()
	{
		ParseYamlFile.waitTime=Config.ElementWaitTime;
	}
	/**
	 * 更改页面元素显示等待时间
	 */
	protected static  void changWaitTimeToVar(int time)
	{
		ParseYamlFile.waitTime=time;
	}
	 public void  getScreen() 
	 {
		 
//		 screen =new Screen();

	 }
	 
		
//	 得到sql查询结果
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
		  * 页面类在定位前执行
		  * @param yamlname  yaml文件名称
		  */
		 protected  static void getBeforeElement (String yamlname) 
		 {
			 getYamlFile(getYamlPath(yamlname));
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
			Log.logInfo(this.getYamlPath("class")); 
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
			Log.logError("yaml 文件没找到");
			e.printStackTrace();
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
	protected static    WebElement  getElemnt(String element,Boolean wait, Boolean replace,String a,String b)
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
	protected static   List<WebElement> getElemnts (String elementName,String a,String b)
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
					ErrorLog.logError(e.toString(), GetClassMethodName());
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
					ErrorLog.logError("mysqlxml文件配置错误请检查");
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
			ErrorLog.logError(e.toString());
			return null;
		}
		  
		}
		String excelpath="";		
	  public  void excelInt()
		{
//				获得excel文件
					 excelpath=this.getClass().getSimpleName();			
				
			
		}

}
