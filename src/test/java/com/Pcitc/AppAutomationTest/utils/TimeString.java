package com.Pcitc.AppAutomationTest.utils;




import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 获得不同格式的时间
 * @author Administrator
 *
 */

import org.testng.annotations.Test;
public class TimeString  extends GetClassMethodName
{
	private static String valueOfString(String str,int len)
	{
		String  string ="";
		for (int i =0;i<len-str.length();i++)
		{
			string = string + "0";
		}
		return (str.length() ==len)?(str):(string + str);
	}

	/**
	 * 返回当前时间：格式为：YYYY-MM-DD  HH:MM:SS
	 * @return
	 */
	public static String  getyMDHMS()
	{
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		return df.format(new Date());
	}
	
	/**
	 * 返回当前时间：格式为：yyyy/MM/dd
	 * @return
	 */
	public static String  getYMD()
	{
		SimpleDateFormat df= new SimpleDateFormat("yyyy/MM/dd");
		return df.format(new Date());
	}
	/**
	 * 返回当前时间：格式为：yyyyMMdd
	 * @return
	 */
	public static String  getYMD2()
	{
		SimpleDateFormat df= new SimpleDateFormat("yyyyMMdd");
		return df.format(new Date());
	}
	/**
	 * 返回当前时间：格式为：yyyy-MM-dd
	 * @return
	 */
	public static String  getY_M_D()
	{
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date());
	}
	public  static String getTime()
	{
		return String.valueOf(new Date().getTime());
	}
//	获得当前时间 精确放到毫秒
	
	@Test
	public void  y()
	{
//	String aString=	getyMDHMS();
//	System.out.println(aString);
	String b=	getYMD2();
	System.out.println("all"+b);
//	System.out.println("date:"+b.substring(0, 10));
//	System.out.println("year:"+b.substring(0, 4));
//	System.out.println("month:"+b.substring(5, 7));
	}
}
