package com.Pcitc.AppAutomationTest.utils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import com.Pcitc.AppAutomationTest.base.TestBase;
import com.Pcitc.AppAutomationTest.pagesHelper.Config;
/**
 * 创建页面截图类
 * @author Administrator
 *
 */
public class ScreenShots extends GetClassMethodName
{

//	创建webdriver的对象
	private WebDriver nsdriver;
//	截图后剪裁
	OperateImage  oi=null;
//	构造函数 初始化webdriver
	public ScreenShots( WebDriver driver)
		{
		 
		 this.nsdriver=driver;
		 oi=new OperateImage();
		}
//	被调用截图方法
	public  void takeScreenshots (WebElement element,String screenFileName) 
	{
		
		try{
			String fileObPath=Config.SnapshotLib+screenFileName+".png";
			System.out.println("takeScreenshots获得截图文件名"+screenFileName+".png");
			File screenshotFile =((TakesScreenshot)nsdriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(fileObPath));
			if (element!=null) 
			{
				oi.cropImage(fileObPath,fileObPath.replace(".png", "Cut.png"), 0,element.getLocation().getY() , TestBase.action.Width, 100,"png","png");//剪切图片
		    	Log.logInfo("截图裁剪完毕",GetClassMethodName()); 
			}
			else {
				Log.logWarn("webelement为null无法精确截图", GetClassMethodName(),"");
			}
			
		}
		catch(Exception e)
		{	
		Log.logError(e.toString(),GetClassMethodName());
		}
	}
//	屏幕截图方法å
	/*/
	public String takeScreenshot(String CaseNo)
		{
//		创建日期格式对象
		SimpleDateFormat  dateformat=new SimpleDateFormat("yyyy年MM月dd日-HH时mm分ss秒");
//		新增字符串变量，内容是已日期格式.png
		String screenName=String.valueOf(CaseNo+":"+dateformat.format(new Date().getTime()))+".png";
//		创建一个目录用于存放截图文件，如果目录没有就创建
		File dir=new File(Config.SnapshotLib);
		if(!dir.exists())
		{
			dir.mkdirs();
		}
//		定义一个字符串变量，用于返回截图文件的绝对路径文件名，给日志方法调用
		String screenPath=dir.getAbsolutePath()+"/"+screenName;
//		执行截图方法
//		this.takeScreenshots(screenPath);
//		返回文件名
		return screenName;
		}

*/

}
