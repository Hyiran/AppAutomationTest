package com.Pcitc.AppAutomationTest.utils;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Pcitc.AppAutomationTest.base.TestBase;
import com.Pcitc.AppAutomationTest.pagesHelper.Config;

import sun.util.logging.resources.logging;
public class Assertion extends GetClassMethodName
{	
//用于监听类监听
    public static boolean flag = true;
//    用例编号 ，用于输出到日志及报告中
    public  String assCaseNo="";
//    测试步骤 当更换用例重置 默认为1
    public  int step=1;
  //用于监听类监听
    public static List<Error> errors = new ArrayList<Error>();
//    日志中的测试内容
    private  String outPutinfor="";
//    截图文件名
    private  String snapShootFileName="";
//    测试结果包含 预期及 实际
    private  String testResault="";
    /**
     * 获得日志中的测试内容
     * @param message
     * @return
     */
 
    private String  getOutputStr(String message ) 
    {
    	 outPutinfor="测试用例："+TestBase.caseNo+"-步骤:"+step+"-测试"+message+"是否正确";
    	 return outPutinfor;
	}
    /**
     * 得到截图路径
     * @param pinString 是否拼接字符串，为真用于日志输出，为假得到截图文件名
     * @return
     */
    private String  getSnapFileName(boolean pinString) 
    {
    	if (pinString) {
    		snapShootFileName="；截图文件："+TestBase.caseNo+"-步骤"+step;
        	return snapShootFileName;
		}
    	else {
    		snapShootFileName= TestBase.caseNo+"-步骤"+step;
        	return snapShootFileName;
		}
    
	}

    /**
     * 得到测试结果包含 预期及 实际
     * @param message 测试的对象 调用时从excle中的断言句列读
     * @return
     */
    private String  getRes(boolean right,Object  expected, WebElement actual) 
    {
    	
    	if (right) 
    	{
   		
    	testResault="-测试结果:测试成功!预期结果："+expected+"；实际结果："+DataHandle.getElementText(actual);
    	return testResault;
    	
		}
    	else {
    	testResault="-测试结果:测试失败!预期结果："+expected+"；实际结果："+DataHandle.getElementText(actual);
		return testResault;
		}
	}
    /**
     * 获得最新用例编号及步骤
     */
    private void  getNewCaseNo()
    {
//	  如果类中的用例编号与TestBase的一致，增加步骤不改用例编号
  	   if (assCaseNo.equals(TestBase.caseNo))
  	   {
         	step++;	
  	   }
         else {
//      	   获得当前编号，重置步骤
         	assCaseNo=TestBase.caseNo;
         	step=0;
         }	
    }
    /**判断元素的预期结果与实际结果是否一致
     * 
     * @param actual 预期结果
     * @param expected 实际结果
     * @param message 判断内容
     * @param dw webdriver 对象
     */
    public  void verifyEquals(Object  expectedObject, WebElement actualWebElement,String message,WebDriver driver){
        try{
//        	获得编号
        	getNewCaseNo();
//        	进行断言
            Assert.assertEquals(expectedObject, DataHandle.getElementText(actualWebElement));
//            断言成功日志输出
     	   Log.logInfo(getOutputStr(message)+getRes(true, expectedObject, actualWebElement), GetClassMethodName());
        	}
        catch(Error e)
        {
//        	失败操作
            errors.add(e);
        	flag = false; 
//			执行截图操作			
			TestBase.screenShots.takeScreenshots(actualWebElement, getSnapFileName(false));			
//			使用log写入report及log文件中：
			Log.logWarn(getOutputStr(message)+getRes(false, expectedObject, actualWebElement), GetClassMethodName(), getSnapFileName(false));
		
        }
    }
    
    /**
     * 测试2个对象是否不相同
     * @param mycaseNo  测试用例编号
     * @param expected   预期结果
     * @param actual   实际结果
     * @param message   打印到log信息
     * @param driver   驱动
     */
    public  void verifyNotEquals(Object expectedObject, WebElement actualWebElement,String message,WebDriver driver){
        
        try{
//        	获得编号
        	getNewCaseNo();
//        	进行断言
            Assert.assertNotEquals(expectedObject, DataHandle.getElementText(actualWebElement));
//            断言成功日志输出
     	   Log.logInfo(getOutputStr(message)+getRes(true, expectedObject, actualWebElement), GetClassMethodName());
        	}
        catch(Error e)
        {
//        	失败操作
            errors.add(e);
        	flag = false; 
//			执行截图操作			
			TestBase.screenShots.takeScreenshots(actualWebElement, getSnapFileName(false));			
//			使用log写入report及log文件中：
			Log.logWarn(getOutputStr(message)+getRes(false, expectedObject, actualWebElement), GetClassMethodName(), getSnapFileName(false));
		
        }
    } 
   

 /**
  * 判断页面元素是否存在，用于判断对象出现的情况
  * @param element 页面对象
  * @param message 输出语句
  * @param driver weblement
  */
    public  void webElementIsNotNull(WebElement webElement,String message,WebDriver driver){
        try{
//        	获得编号
        	getNewCaseNo();
//        	进行断言
            Assert.assertNotNull(webElement);
           
        	Log.logInfo(getOutputStr(message)+"；测试结果:测试成功!元素已被定位！", GetClassMethodName());				
        }catch(Error e)
        {

//			     	失败操作
            errors.add(e);
        	flag = false; 
         	Log.logInfo(getOutputStr(message)+"；测试结果:测试失败!元素未被定位！", GetClassMethodName());		
        }
    }
    /**
     * 判断页面元素是否存在，用于判断对象销消失情况
     * @param element 页面对象
     * @param message 输出语句
     * @param driver weblement
     */
    public  void webElementIsNull(WebElement webElement,String message,WebDriver driver){
    
            try{
//            	获得编号
            	getNewCaseNo();
//            	进行断言
                Assert.assertNull(webElement);
               
            	Log.logInfo(getOutputStr(message)+"；测试结果:测试成功!元素消失！", GetClassMethodName());				
            }catch(Error e)
            {
//    			     	失败操作
                errors.add(e);
            	flag = false; 
//            	执行截图操作			
    			TestBase.screenShots.takeScreenshots(webElement, getSnapFileName(false));			
//    			使用log写入report及log文件中：
    			Log.logWarn(getOutputStr(message)+"；测试结果:测试失败!元素还在页面上！", GetClassMethodName(), getSnapFileName(false));
            }

    }  
    
//	判断按钮是否可以点击
	public  void buttonisDisplayed(String mycaseNo,WebElement element ,String message,WebDriver driver){
		boolean isDisplayed = false;
		try{		

			 if (TestBase.caseNo.equals(mycaseNo))
	      	   {
//	      		   如果传入的用例编号与当前一致，增加步骤不改用例编号
//	      		   TestBase.caseNo=mycaseNo;
	             	step++;	
	      	   }
	             else {
//	          	   获得当前编号，重置步骤
	          	   TestBase.caseNo=mycaseNo;
	              	step=0;
	 			}
			isDisplayed = element.isDisplayed();
			Assert.assertTrue(isDisplayed, message);
			Log.logInfo("测试用例："+TestBase.caseNo+"步骤:"+step+"-"+message+"；测试结果:测试成功！按钮可点击！", GetClassMethodName());	
		}catch(Error e){
			 errors.add(e);
//				定义截图文件名变量
				String screenShotsfileName;
//				创建截图对象实例
				ScreenShots myScreenShots=new ScreenShots(driver);		
////				执行截图操作。得到截图文件名
//				screenShotsfileName="测试用例编号："+TestBase.caseNo+":"+myScreenShots.takeScreenshot(TestBase.caseNo+":"+step);	
//				使用log体系输出:预期结果+实际结果+文件名称
//			 ErrorLog.logError("测试用例："+TestBase.caseNo+"步骤:"+step+"-"+message+"；测试结果:测试失败！按钮可被点击！失败截图名："+screenShotsfileName, GetClassMethodName()); 
			 flag = false;
		}
		
	}	
	
	
//	判断按钮是否可以点击
	public  void isTrue(String caseNo,Boolean object ,String message,WebDriver driver){
		boolean isDisplayed = false;
		try{		

			 if (TestBase.caseNo.equals(caseNo))
	      	   {
//	      		   如果传入的用例编号与当前一致，增加步骤不改用例编号
//	      		   TestBase.caseNo=mycaseNo;
	             	step++;	
	      	   }
	             else {
//	          	   获得当前编号，重置步骤
	          	   TestBase.caseNo=caseNo;
	              	step=0;
	 			}
			
			Assert.assertTrue(object);
			Log.logInfo("测试用例："+TestBase.caseNo+"步骤:"+step+"-"+message+"；测试结果:测试成功！对象为真！", GetClassMethodName());	
		}catch(Error e){
			 errors.add(e);
//				定义截图文件名变量
				String screenShotsfileName;
//				创建截图对象实例
				ScreenShots myScreenShots=new ScreenShots(driver);		
//			执行截图操作。得到截图文件名
//				screenShotsfileName="测试用例编号："+TestBase.caseNo+":"+myScreenShots.takeScreenshot(TestBase.caseNo+":"+step);	
//				使用log体系输出:预期结果+实际结果+文件名称
//			 ErrorLog.logError("测试用例："+TestBase.caseNo+"步骤:"+step+"-"+message+"；测试结果:测试失败！对象为假！失败截图名："+screenShotsfileName, GetClassMethodName()); 
			 flag = false;
		}
		
	}	
	
    }