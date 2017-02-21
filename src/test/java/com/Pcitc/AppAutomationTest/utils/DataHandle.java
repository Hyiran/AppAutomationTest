package com.Pcitc.AppAutomationTest.utils;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.dom4j.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.base.TestBase;
import com.Pcitc.AppAutomationTest.pagesHelper.Location;

import io.appium.java_client.android.AndroidDriver;
import net.sf.saxon.functions.SuperId;
import sun.util.logging.resources.logging;
/**
 * 生成随机数
 * @author Administrator
 *
 */
public class DataHandle extends GetClassMethodName
{     
//	返回一个0-count的随机数
		public int  getRadom(int count)
		{
			return (int)Math.round(Math.random()*(count));
			
		}
		private String string ="1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
//		
		private String Number="1234567890";
		
		public String getRadomString(int length)
		{
			StringBuffer sb= new StringBuffer();
			int len =string.length();
			for(int i=0;i<length;i++)
			{
				sb.append(string.charAt(this.getRadom(len-1)));
			}
			return  sb.toString();
		}
		public long getRadomNumber(int length)
		{
			StringBuffer sb= new StringBuffer();
			int len =Number.length();
			for(int i=0;i<length;i++)
			{
				sb.append(string.charAt(this.getRadom(len-1)));
			}
			return  Long.parseLong(sb.toString());
		}
//		字符串转换整形
		public  static int getInt(String string)
		{
			int i=Integer.parseInt(string);
		   return	i;
		}
//		整形转化字符型
		public  static String getString(int i)
		{
			String s=String.valueOf(i);
			return s;
		}
//		双精度转化字符串
		public  static String getString(Double i)
		{
			String s=String.valueOf(i);
			return s;
		}
//		字符串转化双精度
		public  static double getDouble(String string)
		{
			double s=Double.parseDouble(string);
			return s;
		}
//		双精度按精确位数转化字符串
		/**
		 * 
		 * @param digit  精确位数
		 * @param d     精度数据
		 * @return
		 */
		public  static String getStringDigit(int digit,Double d)
		{
			String s;
			 DecimalFormat df=null;
			 switch (digit) {
			case 1:
				df = new DecimalFormat("#.0");
				break;
			case 2:
				df = new DecimalFormat("#.00");
				break;
			case 3:
				df = new DecimalFormat("#.000");
				break;
			case 4:
				df = new DecimalFormat("#.0000");
				break;
			case 5:
				df = new DecimalFormat("#.00000");
				break;
			case 6:
				df = new DecimalFormat("#.000000");
				break;
			default:
				Log.logError("传入的double类型精确位数不合法，请检查！",GetClassMethodName());
				break;
			}
			 s=df.format(d);
			 return s;
		}
//		public static ExcelReader Excelreader =new ExcelReader("ExcelReader测试","ExcelReader测试数据");
		/**
		 * ExcelReader 对象查询结果返回arrylist
		 * @param excle  ExcelReader 对象
		 * @param dataNumber  对应列有几行数据（只算数据，不考虑标题）
		 * @param columnName 列名
		 * @return
		 */
		public static  ArrayList<String> getArryList(ExcelReader excle,int dataNumber,String columnName) 
		{
//			excle.getCellData(1, 1);
			ArrayList<String>  list=new ArrayList<String> ();
			for (int j = 1; j <=dataNumber+1; j++)
			{
//				第一行为列名，数据从第二行开始
				list.add(excle.getCellData(j, columnName));
			}
			
			return  list;
		}
@Test(description="测试Excelreader数据转化arrylist")
public void  testGetArryList()
{
	ExcelReader Excelreader = new ExcelReader("工时审批","工时下拉列表");
//	获得第一行 第一列的值
//	Excelreader.getCellData(1, 1);
	ArrayList<String>  arrayList=getArryList(Excelreader,7,"审批性质");
	Log.logInfo("list数据："+arrayList.get(2),GetClassMethodName());
}
		/**
		 * 获得页面标题列表
		 * @param className  调用者的类名也就是xml文件名
		 * @return  
		 */
		public  ArrayList<String> getTitle(String className)
		{
			String filePath="./PageTitle/"+className+".xml";
			 Map<String, String> commonMap;
			XMLParase xp=new  XMLParase(filePath);
			Element element= xp.getElementObject("/*/common");
			commonMap = xp.getChildrenInfoByElement(element);
			List<Element> elements=xp.getElementObjects("/*/title");

			Map<String, String>	 mergeCommon = null;
			for(int i=elements.size()-1;i>-1;i--)
			{
				mergeCommon =getMergeMapData(xp.getChildrenInfoByElement(elements.get(i)), commonMap);
			}
			ArrayList<String>  list =new ArrayList<String>();
			  int x=0;
			  for (Map.Entry<String, String> entry : mergeCommon.entrySet()) {
				
				 list.add(entry.getValue());
				 x++;
			  }
			  return list;
//			System.out.println(list.get(0)+list.get(1)+list.get(2));
			
		}
		public static Map<String, String>	getMergeMapData(Map<String, String> map1,Map<String,String> map2)
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
		  * 文本框填入值
		  * @param element  页面对象
		  * @param Key  传入的值
		  */
			public static void elementSedKey(WebElement element,String Key)
			{
			if (element.equals(null)) {
				Log.logError(element.toString()+"没有定位到无法填入值！",GetClassMethodName());
			}
			else {
				element.sendKeys(Key);
				}
			}
		/**
		 * 传入参数获得 by 字符串 用于滑动屏幕所要定位的元素
		 * @param keyWord  用那种定位方式
		 * @param replace  替换参数1
		 * @param replace2  替换参数2
		 * @return  
		 */
		public static String getBy(String keyWord,String replace,String replace2 )
		{
			if(keyWord.equals(Location.TextView_Ptext))
			{
				String by="//android.widget.TextView[starts-with(@text,'"+replace+"')]";
				return by;
			}
			else if (keyWord.equals(Location.TextView_Ptext_Pindex))
			{
				String by="//android.widget.TextView[starts-with(@text,'"+replace+"')]["+replace2+"]";
				return by;
			} 
			else if (keyWord.equals(Location.Button_Ptext))
			{
				String by="//android.widget.Button[starts-with(@text,'"+replace+"')]";
				return by;
			} 
			
			else if (keyWord.equals("TextView_Ptext1"))
			{
				String by="//android.widget.TextView[@text=,'"+replace+"')]";
				return by;
			} 
			else {
				return new String("Tools.GetBy传入定位方式错误 请检查");
						
			}
			
		}
	/**
	 * 获得数据库审批人表中的数据
	 * @param tableNama
	 * @return
	 */
		public  static String getAppMan(String tableNama)
		{
		String aString="select * from "+tableNama;
		return aString;		
		}
		@Test
		public void testgetSelectSqlLeavlScript()
		{
			String mString=getAppMan("FYBXApp");
			System.out.println(mString);
			}
		/**
		 * 
		 * @param tableNama  表明
		 * @param terminalid  终端名
		 * @return
		 */
		public  static String getBookNO(String tableNama,String terminalid)
		{
//			select feiyongbaoxiao from WebGenerateData where terminal='ios' and datano=3
		String aString="select * from "+tableNama+" where terminal='"+terminalid+"'";
		return aString;		
		}
		@Test
		public void testgetSelectSqlTestDataScript()
		{
			String mString=getBookNO("WebGenerateData","ios'");
			System.out.println("审批数据：-----"+mString);
			}
		/**
		 * 批审数据查询
		 * @param tableNama 表明
		 * @param terminalid  平台名
		 * @return
		 */
		public  static String getSelectSqlManyApp(String tableNama,String terminalid)
		{
//		select feiyongbaoxiao from WebGenerateData where terminal='ios' and datano<=1
//			一条数据进行批审
		String aString="select * from "+tableNama+" where terminal='"+terminalid+"'"+" and datano=1";
		return aString;		
		}
		@Test
		public void testgSelectSqlManyApp()
		{
			String mString=getSelectSqlManyApp("WebGenerateData","ios'");
			System.out.println("getSelectSqlManyApp------"+mString);
			}
		/**
		 * 得到element到文本，用于处理定位不到到元素null报错的情况
		 * @param element  定位后的页面元素
		 * @return
		 */
		public  static String getElementText(WebElement element)
		{
		try {
			String text=element.getText();
			return text;
		} catch (Exception e) {
			// TODO: handle exception
			return "无法定位元素";
		}
		}
		/**
		 *清除文本框内容，重新输入
		 * @param element 元素对象
		 * @param value 重新输入的值
		 */
		public void clearInputTextbox(WebElement element,String value){
//			点击进入文本框
			
			TestBase.action.tap(element, 500);
//			获得当前文本长度
			int size = element.getText().length();
//			光标定位到最后一个字符
			AndroidDriver<WebElement> androidDriver=(AndroidDriver<WebElement>)TestBase.appiumDriver;
			androidDriver.pressKeyCode(KeyEvent.TOLASTCHAR);
			for(int i =0;i<size;i++){
//				依次退格直到完全清除
//				driver.sendKeyEvent(AndroidKeyCode.BACKSPACE);
//				TestBase.driver.pressKeyCode(KeyEvent.fanHui);
				
				androidDriver.pressKeyCode(KeyEvent.fanHui);
			}
//			    重新输入字符
			element.sendKeys(value);
			
		}
		
		/**
		 * 将数据驱动Map<String, String> 数据转化为ArrayList；
		 * @param param Map<String, String> 
		 * @return
		 */
		public  static ArrayList<String> changeToArry(Map<String, String> param)
		{
		ArrayList<String>  list =new ArrayList<String>();
		  int x=0;
		  for (Map.Entry<String, String> entry : param.entrySet()) {
			
			 list.add(entry.getValue());
			 x++;
		  }
		return list;
		}
}
