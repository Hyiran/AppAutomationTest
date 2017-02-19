package com.Pcitc.AppAutomationTest.utils;

import java.util.ArrayList;
import java.util.Map;
import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.base.TestBase;


/**
 * Xml数据驱动
 Xml文件名必须与java测试类文件名保持一致，比如TestLogin.java的测试类，则数据文件必须为TestXMLProvider.xml
 Xml里面的二级结点名必须与测试方法名保持一致。比如有个测试方法provider1要运行两遍
 * @author Administrator
 *
 */
public class DataProviderTest  extends TestBase
{
	@Test(dataProvider="xml",dataProviderClass= com.Pcitc.AppAutomationTest.base.TestBase.class)
	public void xmldDataprovider2(Map<String, String> param1)
		{
		System.out.println(param1.get("a1"));
		System.out.println(param1.get("a2"));
		}

/**
 * MySQL 数据驱动
 * 用法：在Mysql目录下创建与测试类同名文件.xml文件，维护链接名 用户名 密码标签，以及sql标签，sql标签要和类中方法的方法名一致
 * @param a  第一列的列名 可以与数据库的列不一致
 * @param b  第二列
 * @param c
 */
//@Test(dataProvider="Mysql", dataProviderClass=TestBase.class)
	
		public void TravelAppNew_Book(String name,String  age)
		{
			 System.out.println(age);
		}	


		/** 使用excle文件做做数据驱动，测试textbase类的的excel数据驱动
		 * @Test(dataProvider="excle", dataProviderClass=TestBase.class) 固定写法 找到dataprovider类的地址
		 * 调用者的类必需与excle文件的文件名一致
		 * 调用者的方法必需与sheet名字一致
		 * excle文件必需是xslx为拓展名
		 */
//  @Test(dataProvider="excle", dataProviderClass=TestBase.class,description="测试excle数据驱动，并将返回对象转换到arrylist中")
	  
	    public void Sheet1( Map<String, String> param) 
		  {
	 
		  ArrayList<String> op =changeToArry(param);			
		  System.out.println(op.size());		
		  System.out.println(op.size());		
//		  System.out.println("内部");

		
		
		  } 


//@Test(description="测试读取excle文件")

public void testExcel() throws Exception
{
	ExcelReader Excelreader = new ExcelReader("数据驱动文件","数据驱动文件数据");
	Log.logInfo(Excelreader.getCellData(1, 1)); //  第一行第一列的值
	Log.logInfo(Excelreader.getCellData(1, "密码")); 
//	Object [][] aObjects=Excelreader.getMapData;
	// 数据预期结果列第一行数据
//	System.out.println("size=="+Excelreader.getMapData.size());  //获得行数
//	System.out.println(Excelreader.getMapData.get(0)); //获得第一行中所有的数据
//	System.out.println(Excelreader.getMapData.get(0).get("数据预期结果"));  //获得第一行数据预期结果列数据
//
}
public ArrayList<String> changeToArry(Map<String, String> param)
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
