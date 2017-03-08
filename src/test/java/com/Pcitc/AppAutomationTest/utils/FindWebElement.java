package com.Pcitc.AppAutomationTest.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import org.ho.yaml.Yaml;
import org.ho.yaml.exception.YamlException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Pcitc.AppAutomationTest.base.TestBase;
import com.Pcitc.AppAutomationTest.pagesHelper.Config;
import com.Pcitc.AppAutomationTest.pagesHelper.TestInit;

public class FindWebElement  extends GetClassMethodName

{
	private WebDriver FindWebElementDriver =null ;
	ExcelReader excelReader=null;
//	元素等待时间
//	public static int waitTime=Config.ElementWaitTime;
//元素是否能被找到，用于区别正常场景找不到元素 不报错的时候
	public static boolean needFound=true;
	//构造函数参数,初始化webdriver对象
/**
 * 初始化webdriver对象
 * @param driver
 */
	public FindWebElement(WebDriver driver )
	{
		FindWebElementDriver=driver;
	}

/**
 * 对by对象进行封装
 * @param ByType 定位方式（xpath /id等）
 * @param locatString  定位器字符串
 * @return by对象
 */
private By getBy(String ByType,String locatString)
{

	By by =null;
	
	if (ByType.equals("id"))
		{
	//	如果type的值是id  就将by封装成by。id
		by=By.id(locatString);
		}
//	如果type的值是xpath  就将by封装成by。xpath
	else if (ByType.equals("xpath"))
		{
			by=By.xpath(locatString);
		}
	else
// 如果都不是报错
		{
			Log.logError("无效的定位方式，"+ByType+"请检查excle文件！",GetClassMethodName());
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
			element = new WebDriverWait(FindWebElementDriver, Config.ElementWaitTime).until(new ExpectedCondition<WebElement>()
			
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
				Log.logInfo("需要定位元素",GetClassMethodName());
					       
				Log.logWarn("页面元素"+WebElementName+",无法用定位方式："+by.toString()+ "找到!超时时间:"+Config.ElementWaitTime,GetClassMethodName(),"");
				
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
			wait = new WebDriverWait(FindWebElementDriver,Config.ElementWaitTime)
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

//不等待页面元素出现
  public WebElement getElementNoWait(ExcelReader e ,String byTypeColumn ,String locatStringcolumn )
  {
		return this.getLocator(e, false, byTypeColumn, locatStringcolumn);
  }
 
//不等待页面元素出现
  public WebElement getElementWait(ExcelReader e ,String byTypeColumn ,String locatStringcolumn )
  {
		return this.getLocator(e, true, byTypeColumn, locatStringcolumn);
  }




//获得webelements
public  List<WebElement> getElemens(ExcelReader e ,String byTypeColumn ,String locatStringcolumn)
{
	return this.getLocators(e,byTypeColumn,locatStringcolumn);
}
	//封装Webelement对象动态替换

	//由于getElementNoWait、getElement两个类相似，先编写测试类 存放相同的方法体，在修改两个方法
private String WebElementName="";

/**
 * 定位元素 
 * @param e  excle对象（testbase。PageElmentExcle）
 * @param wait 是否等
 * @param ByTypeColumn  定位方式
 * @param locatStringColumn 定位器
 * @return
 */
private WebElement getLocator(ExcelReader e ,boolean wait,String ByTypeColumn,String locatStringColumn)
{
	WebElement element =null;
	
	String ByType="";
	String locatString="";
	if(e!=null)
	{
		excelReader=e;
		if (ByTypeColumn.contains("字段"))
		{
			WebElementName=excelReader.getCellData(TestBase.PageElmentExcleIndex, "字段标识符");
		}
		else {
			WebElementName=excelReader.getCellData(TestBase.PageElmentExcleIndex, "数据标识符");
		}
		
		ByType=excelReader.getCellData(TestBase.PageElmentExcleIndex, ByTypeColumn);
		locatString=excelReader.getCellData(TestBase.PageElmentExcleIndex, locatStringColumn);	
		if (ByType!=null && locatString!=null)
		{
			Log.logInfo("对象："+WebElementName+";定位方式："+ByType+";定位器："+locatString, GetClassMethodName());
			By by=this.getBy(ByType, locatString);	
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
					element =FindWebElementDriver.findElement(by);
					}
				catch(Exception e2)
					{
					Log.logInfo("页面元素没有在页面上发现",GetClassMethodName());									
					}
			}
		}
		else 
		{
			Log.logError("定位器或定位方式在excle中读取失败，无法找到页面元素",GetClassMethodName());
		}
		
	
	}
	else
		Log.logError("PageElmentExcle 为 null！请初始化！",GetClassMethodName());
		
	
	return element;
}
/**
 * 
 * @param key 定位器名称
 * @param a  替换的参数1
 * @param b  替换的参数2
 * @return
 */
private List<WebElement>  getLocators(ExcelReader e ,String ByTypeColumn,String locatStringColumn) 
{
	List<WebElement> elements =null;
	
	String ByType="";
	String locatString="";
	if(e!=null)
	{
		excelReader=e;
		if (ByTypeColumn.contains("字段"))
		{
			WebElementName=excelReader.getCellData(TestBase.PageElmentExcleIndex, "字段标识符");
		}
		else {
			WebElementName=excelReader.getCellData(TestBase.PageElmentExcleIndex, "数据标识符");
		}
		ByType=excelReader.getCellData(TestBase.PageElmentExcleIndex, ByTypeColumn);
		locatString=excelReader.getCellData(TestBase.PageElmentExcleIndex, locatStringColumn);	
		By by=this.getBy(ByType, locatString);	
		try {
			elements =FindWebElementDriver.findElements(by);
		} catch (Exception e3) 
		{
			Log.logError("webelements："+WebElementName+"无法用"+ByType+":"+locatString+"定位到！，请检查定位器",GetClassMethodName());
		return null;
		}
	
				
	return elements;
	}
	else
	{
		Log.logError("PageElmentExcle 为 null！请初始化！",GetClassMethodName());
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
