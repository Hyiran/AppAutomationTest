package com.Pcitc.AppAutomationTest.utils;



import java.util.concurrent.TimeUnit;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.ios.IOSDriver;
import sun.util.logging.resources.logging;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;


import com.Pcitc.AppAutomationTest.base.TestBase;
import com.Pcitc.AppAutomationTest.pagesHelper.Config;
import com.Pcitc.AppAutomationTest.pagesHelper.PageFuntion;
import com.Pcitc.AppAutomationTest.pagesHelper.TestInit;

import bsh.commands.dir;

public class Action extends GetClassMethodName {

	public AppiumDriver<WebElement> driver;
//	创建driver的驱动
	public AndroidDriver androidDriver;
//	创建driver的驱动
	public IOSDriver iosDriver;
//	获得横坐标长度，x轴
	public int  Width;
//	获得横坐标长度，y轴
	public int Height;
//	滑动次数
	int  Times;
WebElement EndElement;

	/**
	 * 构造函数初始化三个对象
	 * @param driver
	 */
	public Action(AppiumDriver Driver)
	{	
//		获得 driver
	
//		对于appium的对象用driver，iosDriver anroid 用各自的driver
//		driver = TestBase.appiumDriver;
		driver=Driver;
//		如果当前环境是ios测试就初始化iosDriver
		if (TestInit.IsAndroid) 
		{
			androidDriver=(AndroidDriver) TestBase.appiumDriver;
			Log.logInfo("测试环境为Android，转化为AndroidDriver",  GetClassMethodName());
		
			
		}
		else 
		{
			iosDriver=(IOSDriver) TestBase.appiumDriver;
			Log.logInfo("测试环境为ios，转化为iosDriver",  GetClassMethodName());
			
		}
		
//		获得屏幕宽高
		Width=driver.manage().window().getSize().width;
		Height=driver.manage().window().getSize().height;
		Log.logInfo("获取屏幕宽高成功,高："+Height+"宽："+Width,  GetClassMethodName());
	}
	/**
	 * 锁屏s
	 */
	public void lockScreen()
	{	
		driver.lockScreen(3);
		Log.logInfo("",  GetClassMethodName());
	}
	/**
	 *清除文本框内容，重新输入
	 * @param element 元素对象
	 * 
	 */
	public void clearInputTextbox(WebElement element ){
//		点击进入文本框
		tap(element, 500);
//		获得当前文本长度
		int size = element.getText().length();
		Log.logInfo("文本框当前字符长度为："+size, classMethodeName);
//		光标定位到最后一个字符
		androidDriver.pressKeyCode(KeyEvent.TOLASTCHAR);
		for(int i =0;i<size;i++){
//			依次退格直到完全清除
			androidDriver.pressKeyCode(KeyEvent.DEL);
		}
//		   
		
	}

	/**
	 * 键盘事件（安卓）
	 * @param key
	 */
	public void  pressKeyCode(int key)
	{	
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		androidDriver.pressKeyCode(key);
	}
/**
 * 将 app 置于后台
 */
	public void Background()
	{	
		driver.runAppInBackground(5);
	}
	/**
	 *收起键盘
	 */
	public void hideKeyboard()
		{	
			driver.hideKeyboard();
		}
	/**
	 *在当前应用中打开一个 activity 或者启动一个新应用并打开一个 activity 。 只能在 Android 上使用
	*@param  appWaitPackage 如果不用 就传null
		*/
	public void startActivity(String appPackage,String appActivity,String appWaitPackage,String appWaitActivity)
			{	
			if (appWaitActivity !=null) 
			{
				androidDriver.startActivity(appPackage, appActivity, appWaitPackage, appWaitActivity);
			}
				
			else {
				androidDriver.startActivity(appPackage, appActivity);
			}
			}	
			/**
	 *打开通知栏 (Notifications)
			 */
	public void openNotifications()
				{	
					androidDriver.openNotifications();
				}
	/**
	 *检查应用是否已经安装
	 *@param 包名
	 */
	public boolean isAppInstalled(String packageName)
		{	
		boolean AppInstalled =driver.isAppInstalled(packageName);
		return AppInstalled;
		}
				/**
				 *安装应用到设备中去
				 *@param appPath 应用的绝对路径
				 *@param packageName  应用包名
				 *@return 是否安装成功
				 */
	public boolean installApp(String appPath,String packageName)
	{	
	driver.installApp(appPath);
	boolean AppInstalled =driver.isAppInstalled(packageName);
	return AppInstalled;
		}
	/**
	*卸载应用
	 *@param packageName  应用包名
	 *
	 */
	public void removeApp(String packageName)
	{	
	driver.removeApp(packageName);				
	}
	/**
	 *摇晃 只试用ios
	 *@param packageName  应用包名
	 *
	 */
	public void shake(String packageName)
	{	
	iosDriver.shake();				
	}		
	/**
	 *关闭app
	 *
	 *
	*/
	public void closedApp()
	{	
	driver.closeApp();
	}	
		
	/**启动 (Launch)
	 * 根据服务关键字 (desired capabilities) 启动会话 (session) 。
	 * 请注意这必须在设定 autoLaunch=false 关键字时才能生效。这不是用于启动指定的 app/activities ————你可以使用 start_activity 做到这个效果————这是用来继续进行使用了 autoLaunch=false 关键字时的初始化 (Launch) 流程的。
	 */
	public void launchApp()
	{	
	driver.launchApp();
	}	
	/**
	 *列出所有的可用上下文
	 *翻译备注：context可以理解为 可进入的窗口 。例如，对于原生应用，可用的context和默认context均为NATIVE_APP
	*/

	public void getContextHandles()
	{	
	driver.getContextHandles();
	}				
	

	/**封装tap对象
	 * 
	 * @param element  Webelement
	 * @param  Millisecond 持续时间
	 * @return 是否退出当前用例执行，true 退出
	 */
	public void tap(WebElement element ,int Millisecond){	
		if (element!=null) {
			driver.tap(1, element, Millisecond);
//			return false;
		}
		else {
			Log.logError("WebElement:"+element.toString()+"未被定位无法点击！",GetClassMethodName());
//			PageFuntion.exceptionLogOutAndroid();
//			return true;
			}
			
	}
	/**封装sendkey对象
	 * @param element  Webelement
	 * @param  string 输入的字符串
	 */
	public void sendKey(WebElement element,String string){	
		if (element!=null)
		{
			element.sendKeys(string);
			TestBase.assertion.verifyEquals("向文本框输入字符串",string, element, "测试文本框数据是否输入成功", androidDriver);
		}
		else 
		{
			Log.logWarn("WebElement:"+element.toString()+"未被定位无法输入字符串！",GetClassMethodName(),"");
		}
	}
	/**封装sendkey对象
	 * 
	 * @param element  Webelement
	 * @param  row 行号
	 * @param  ColumnName 列名
	 */
	public void sendKeyByExcle(WebElement element,int row,String ColumnName){	
		if (element!=null)
		{
			String inputData="";
			inputData=TestBase.PageElmentExcle.getCellData(row, ColumnName+"数据");
			if (inputData !="") 
			{
				element.sendKeys(inputData);
				TestBase.assertion.verifyEquals("测试文本框数据是否输入",inputData, element, "测试文本框数据是否输入", androidDriver);
			}
			else {
				Log.logWarn("没有获取到excle数据请检查文件,无法在文本框输入", GetClassMethodName(),"");
				}
		}
		else 
		{
			Log.logWarn("WebElement:"+element.toString()+"未被定位无法输入字符串！",GetClassMethodName(),"");
		}
	}
	/**
	 * 
	 * @param x x坐标
	 * @param y y坐标
	 * @param Millisecond 持续时间
	 */
		public void tap(int x ,int y ,int Millisecond)
		{	
			driver.tap(1, x, y, Millisecond);
				
		}
		/**
		 * @param figNo 手指数
		 * @param x x坐标
		 * @param y y坐标
		 * @param Millisecond 持续时间
		 */
			public void tapWithManyFin(int figNo,int x ,int y ,int Millisecond)
			{	
				driver.tap(figNo, x, y, Millisecond);
				
					
			}
	/**
	 * 页面上下滑动
	 * @param endBy 最终要得到的对象
	 * @param times 滑动次数
	 * @param direction =滑动方向
	 * @throws InterruptedException 
	 * 
	 */

		
	public WebElement  swipe(By by,String  direction,int times ,boolean swipeAgain) {
		Boolean findElement=false;	
		Times=times;
		try {
			 	EndElement=driver.findElement(by);		
			 	findElement=true;
			 	Log.logInfo("action.swip:数据默认存在,无需滑动",GetClassMethodName()); 	
			 	return EndElement;			
		} catch (Exception e) 
		{
			Log.logInfo("默认找不到数据，即将开始滑动", GetClassMethodName());
		}
					
				 if(direction=="up")
					{
					 Log.logInfo("页面开始向上滑动",GetClassMethodName());
//						滑动页面,向上滑动，根据动times次
						for(int i=0;i<=Times;i++)
						{
							try {
//								向上滑动每次划区屏幕长度的10%，最多滑动i次
									driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);	
									driver.swipe((int)(0.5*Width), (int)(0.6*Height), (int)0.5*Width, (int)(0.4*Height), 1500);
								    EndElement=driver.findElement(by);	
//									}
								    findElement=true;
									Log.logInfo("第："+i+" 次滑动已找到元素对象！",GetClassMethodName());
									if (swipeAgain)
								 	{
									driver.swipe((int)(0.5*Width), (int)(0.6*Height), (int)0.5*Width, (int)(0.4*Height), 1500);	
									 EndElement=driver.findElement(by);	
										Log.logInfo("swipe多滑动一次",GetClassMethodName());
									}
									driver.manage().timeouts().implicitlyWait(Config.implicitlyWaitTime, TimeUnit.SECONDS);				
																
									break;					
								   						
							} catch (Exception e)
							{
								System.out.println("第："+i+" 次滑动没有找到元素对象！");
								Log.logInfo("第："+i+" 次滑动没有找到元素对象！", GetClassMethodName());
							}
						
						}
						return EndElement;
					}
					else if(direction=="down")
					{
						driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//						向下滑动每次划区屏幕长度的10%，最多滑动20次
						for(int i=0;i<=Times;i++)
						{
							try {
//								向上滑动每次划区屏幕长度的10%，最多滑动20次
								
								driver.swipe((int)(0.5*Width), (int)(0.3*Height), (int)0.5*Width, (int)(0.5*Height), 1500);					
								EndElement=driver.findElement(by);
								Log.logInfo("第："+i+" 次滑动已找到元素对象！",GetClassMethodName());
								findElement=true;
								driver.manage().timeouts().implicitlyWait(Config.implicitlyWaitTime, TimeUnit.SECONDS);
								break;
							} catch (Exception e) {
								Log.logInfo("第："+i+" 次滑动没有找到元素对象！",GetClassMethodName());
										
							}
						
						}
						return EndElement;
						
					}
					else if(direction=="left")
					{
						driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//						向下滑动每次划区屏幕长度的10%，最多滑动20次
						for(int i=0;i<=Times;i++)
						{
							try {
//								向左动每次划区屏幕宽度的40%，最多滑动20次
//								driver.swipe(startx, starty, endx, endy, duration);
								driver.swipe((int) (0.8*Width), (int)(0.5*Height),(int) (0.05*Width), (int)(0.5*Height),1000);		
								EndElement=driver.findElement(by);
								Log.logInfo("第："+i+" 次滑动已找到元素对象！",GetClassMethodName());
								findElement=true;
								driver.manage().timeouts().implicitlyWait(Config.implicitlyWaitTime, TimeUnit.SECONDS);
								break;
							} catch (Exception e) {
								Log.logInfo("第："+i+" 次滑动没有找到元素对象！",GetClassMethodName());
											
							}
						
						}
						return EndElement;
					}
					else if(direction=="right")
					{
						driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//						向下滑动每次划区屏幕长度的10%，最多滑动20次
						for(int i=0;i<=Times;i++)
						{
							try {
//								向左动每次划区屏幕宽度的40%，最多滑动20次
								driver.swipe((int) (0.05*Width), (int)(0.5*Height),(int) (0.8*Width), (int)(0.5*Height), 1000);		
								EndElement=driver.findElement(by);
								Log.logInfo("第："+i+" 次滑动已找到元素对象！",GetClassMethodName());
								findElement=true;
								driver.manage().timeouts().implicitlyWait(Config.implicitlyWaitTime, TimeUnit.SECONDS);
								break;
							} catch (Exception e) {
								Log.logInfo("第："+i+" 次滑动没有找到元素对象！",GetClassMethodName());
								i++;				
							}
						
						}
						return EndElement;
					}
					else 
					{
						driver.manage().timeouts().implicitlyWait(Config.implicitlyWaitTime, TimeUnit.SECONDS);
						Log.logError("Class:Action-Method:swipe:滑动方向传入错误 请检查！",GetClassMethodName());
						return EndElement;
					}
		
	}
	
 public void swipByTimes(int times,String to)
 {
	 if (to.equals("up"))
	 {
		 for (int i = 0; i < times; i++) 
		 {
				driver.swipe(Width/2, Height/2, Width/2, Height/2-300, 1000);
		}
	
	}
	 if (to.equals("down"))
	 {
		 for (int i = 0; i < times; i++) 
		 {
				driver.swipe(Width/2, Height/2, Width/2, Height/2+300, 1000);
		}
	} else
	{
Log.logError(" 滑动方向错误！", GetClassMethodName());
	}
 }
}
	

	
	
