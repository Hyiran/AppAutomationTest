package com.Pcitc.AppAutomationTest.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.ho.yaml.Yaml;
import org.ho.yaml.exception.YamlException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.pagesHelper.Config;

import io.appium.java_client.android.AndroidDriver;
import sun.util.logging.resources.logging;
/**
 * 封装Welement 对象
 * @author jh
 *
 */
/*
关于页面元素的思想
1.考虑页面元素会出现
	1.1 等点元素出现
	1.2等待元素消失
2.页面元素不会出现（不等待）
3.对于多个元素共性的抽取
3.1 如果有一组页面对象，他么有共性的地方，只有一处不同如下
  aaaNUHbbbccc
  aaaJHJbbbccc
  aaaKJGbbbccc
  可以采取动态替换不同出处
3.2 如果有两个页面，，某个部分是相同的可以批量处理替换相同的地方
	AAAAJIJI
	AAAAJKKK
	这样就可以把AAAA动态替换
*/

public class ParseYamlFile extends GetClassMethodName
{
	private WebDriver driver ;
	private HashMap<String, HashMap<String,String>> hashMap;
//	元素等待时间
	public static int waitTime=Config.ElementWaitTime;
//元素是否能被找到，用于区别正常场景找不到元素 不报错的时候
	public static boolean needFound=true;
	//构造函数参数,初始化webdriver对象
/**
 * 初始化webdriver对象
 * @param driver
 */
	public ParseYamlFile(WebDriver driver )
	{
	this.driver=driver;
	
	}
	/**
	 * 加载yanl文件，到hashmap
	 * @param fileAbsolutePath
	 * @throws FileNotFoundException 
	 */
@SuppressWarnings("unchecked")
//获得文件对象，封装hashmap
public  void getYamlFile(String fileAbsolutePath) throws FileNotFoundException
	{
//	形参数是文件的据对路径
//	"PageSouseObjectLib"+yamFileName+".yaml"
//	将文件复制给file对象
	File file= new File(fileAbsolutePath);
	try {
//		定义的HashMap存储文件的内容
		
		hashMap=Yaml.loadType(new FileInputStream(file.getAbsolutePath()),HashMap.class);
		}
	catch(YamlException e)
		{
		//找不到文件时捕获异常
			Log.logError( fileAbsolutePath+"文件不存在"+e.toString(),GetClassMethodName());
		}
}
/**
 * 对by对象进行封装
 * @param 定位方式（xpath /id等）
 * @param value  获得值
 * @return by对象
 */
private By getBy(String type,String value)
{

	By by =null;
	
	if (type.equals("id"))
		{
	//	如果type的值是id  就将by封装成by。id
		by=By.id(value);
		}
//	如果type的值是xpath  就将by封装成by。xpath
	else if (type.equals("xpath"))
		{
			by=By.xpath(value);
		}
	else
// 如果都不是报错
		{
			Log.logError(".getBy:无法找到:"+type+"定位方式，请检查yaml文件",GetClassMethodName());
			by=null;
		}
//	返回封装好的by对象
	return by;
}


/**
 * 等待页面元素出现
 * @param by
 * @return webelement
 */

public WebElement waitForElement(final By by)
	{
	WebElement element=null;
		try  {
			element = new WebDriverWait(driver, waitTime).until(new ExpectedCondition<WebElement>()
			
				 { 
					public WebElement apply(WebDriver d)
						{
						return d.findElement(by);
						}
				 }	);
			}		
		catch (Exception e)
		
		{
			if (needFound) 
			{
//				Log.logInfo("需要定位元素",GetClassMethodName());
					       
				Log.logWarn("页面元素"+WebElementName+",无法用定位方式："+by.toString()+ "找到!超时时间:"+waitTime,GetClassMethodName(),"");
				
			}
			else {
				Log.logInfo("不需要定位元素",GetClassMethodName());
				}	
		}
		return element;
	}

/**
 * 判断页面对象是否存在
 * @param element 页面对象
 * @return  
 */
private boolean waitForElementToDisplayed(final WebElement element)
{
	boolean wait=false;
	if (element==null)
	return wait;
		try  {
			wait = new WebDriverWait(driver,Config.ElementWaitTime)
			.until(new ExpectedCondition<Boolean>()
				{
					public Boolean apply(WebDriver d)
					{
						
						return element.isDisplayed();
					}
				
				});
			}
		catch (Exception e)
		{
			Log.logError("ParseYamlFile.waitForElementToDisplayed:"+e.toString()+"is not displayed",GetClassMethodName());
		}
		return wait;
	}
/**
 * 判断页面对象消失
 * @param element
 * @return
 */
/*private boolean waitForElementBeNotDisPlay(final WebElement element)
{
	boolean wait=false;
	if (element==null)
	return wait;
		try  {
			wait = new WebDriverWait(driver,Config.ElementWaitTime)
			.until(new ExpectedCondition<Boolean>()
				{
					public Boolean apply(WebDriver d)
					{
						
						return !element.isDisplayed();
					}
				
				});
			}
		catch (Exception e)
		{
			Log.logError("Class:ParseYamlFile,Method:waitForElementBeNotDisPlay:"+e.toString()+"对象还在页面上");
		}
		return wait;
	}

*/
//不等待页面元素出现
  public WebElement getElementNoWaitNOReplace(String key)
  {
		return this.getLocator(key,false,null,null);
  }
 
//  不等待页面元素出现，适用于不会出现的
  public WebElement getElementNoWaitReplace(String key,String a,String b)
  {
	
		return this.getLocator(key,false,a,b);
  }
  

//  等待获取单个页面元素，不替换
public  WebElement getElementWaitNOReplace(String key)
{	
	
	return this.getLocator(key, true,null,null);
}

//等待获取单个页面元素，替换
public  WebElement getElementWaitReplace(String key,String p1,String p2)
{	
	
	return this.getLocator(key, true,p1,p2);
}

//获得webelements
public  List<WebElement> getElemens(String key,String a,String b)
{
	return this.getLocators(key,a,b);
}
	//封装Webelement对象动态替换

	//由于getElementNoWait、getElement两个类相似，先编写测试类 存放相同的方法体，在修改两个方法
private String WebElementName="";
private WebElement getLocator(String key ,boolean wait,String a,String b)
{
	WebElement element =null;
	if(hashMap.containsKey(key))
	{
		WebElementName=key;
		HashMap<String, String> m=hashMap.get(key);
		String type=m.get("type");
		String value=m.get("value");
//		如果传的参数不是空就要动态替换
		if(a!=null)
		{
			value=this.getLocaterString(value, a,b);
			Log.logInfo("页面元素定位方式为："+type+"定位器："+value, GetClassMethodName());
		}
		By by=this.getBy(type, value);
		
			if(wait)
			{
//				如果需要等待，获取页面对象
				element =this.waitForElement(by);
				
//				如果在规定的时间内没有找到页面对象，置空对象
				boolean falg= this.waitForElementToDisplayed(element);
					if(!falg)
						element=null;
			}
			else
			{
//				不需要等待（页面不会出现元素）
				try
					{
					element =driver.findElement(by);
					}
				catch(Exception e)
					{
					Log.logInfo("等待："+driver.manage().timeouts()+"秒后元素消失",GetClassMethodName());									
					}
			}
	
	}
	else
		Log.logError("Class:ParseYamlFile,Method:getLocators:页面元素“"+key+"”无法在yaml文件找到，请检查传入参数！",GetClassMethodName());
		
	
	return element;
}
/**
 * 
 * @param key 定位器名称
 * @param a  替换的参数1
 * @param b  替换的参数2
 * @return
 */
private List<WebElement>  getLocators(String key ,String a,String b) 
{
	List<WebElement> elements =null;
	if(hashMap.containsKey(key))
	{
		HashMap<String, String> m=hashMap.get(key);
		String type=m.get("type");
		String value=m.get("value");
//		如果传的参数不是空就要动态替换
		if(a!=null)
		{
			value=this.getLocaterString(value, a,b);
			Log.logInfo("页面元素定位方式为："+type+"定位器："+value, GetClassMethodName());
		}
		By by=this.getBy(type, value);
		try {
			elements =driver.findElements(by);
		} catch (Exception e) {
			Log.logError("五法定位webelements"+value+"，请检查定位方式",GetClassMethodName());
		return null;
		}
	
				
	return elements;
	}
	else
	{
		Log.logError("Class:ParseYamlFile,Method:getLocators:页面元素“"+key+"”无法在yaml文件找到，请检查传入参数！",GetClassMethodName());
		return null;
	}
}

//定义方法用于将文件的内容替换成参数内容
private String getLocaterString(String locatorString,String p1,String p2)
{
	try {
		if(p2.length()>0)
		{
			String value=String.format(locatorString,p1,p2);
			return value;	
		}
		else
		{
		String value=String.format(locatorString,p1);
		return value;
		}
	} catch (Exception e) {
	
		Log.logError("Class:ParseYamlFile,Method:getLocaterString:传入与yaml配置的定位占位符个数不等："+locatorString+"--"+p1+"--"+p2,GetClassMethodName());
		return null;
	
	
	}
	
}



}