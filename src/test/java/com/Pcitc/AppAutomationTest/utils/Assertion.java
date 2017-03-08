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
//    	获得编号
    	 getNewCaseNo();
    	 outPutinfor="测试用例："+assCaseNo+"-步骤:"+step+"-测试"+message+"是否正确";
    	 return outPutinfor;
	}
    /**
     * 得到截图路径
     * @param pinString 是否拼接字符串，为真用于日志输出，为假得到截图文件名
     * @return
     */
    private String  getSnapFileName(boolean pinString) 
    {
    
    	if (pinString)
    	{	
    		snapShootFileName="；截图文件："+assCaseNo+"-步骤:"+step;
    		
        	return snapShootFileName;
		}
    	else {
    		
    		
    		snapShootFileName= assCaseNo+"-步骤:"+step;
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
  	   if (assCaseNo.equals(TestBase.testCaseNo))
  	   {
         	step++;	
  	   }
         else {
//      	   获得当前编号，重置步骤
        	 TestBase.testCaseNo=assCaseNo;
         	step=1;
         }	
    }
    /**判断元素的预期结果与实际结果是否一致
     * 
     * @param actual 预期结果
     * @param expected 实际结果
     * @param message 判断内容
     * @param dw webdriver 对象
     */
    public  void verifyEquals(String caseNo,Object  expectedObject, WebElement actualWebElement,String message,WebDriver driver){
        try{
        	assCaseNo=caseNo;
//        断言计数加1
        	TestBase.modelTotalAsser++;
//        	进行断言
            Assert.assertEquals(expectedObject, DataHandle.getElementText(actualWebElement));
//            断言成功日志输出
     	   Log.logInfo(getOutputStr(message)+getRes(true, expectedObject, actualWebElement), GetClassMethodName());
        	}
        catch(Error e)
        {
        	
        	TestBase.commonlyNo++;
        	TestBase.modelAsserFail++;
//        	失败操作
            errors.add(e);
        	flag = false; 
        	String snapShootName= getSnapFileName(false);
//			执行截图操作			
			TestBase.screenShots.takeScreenshots(actualWebElement, snapShootName);			
//			使用log写入report及log文件中：
			Log.logWarn(getOutputStr(message)+getRes(false, expectedObject, actualWebElement), GetClassMethodName(), snapShootName);
		
        }
    }
    
    /**
     * 测试2个对象是否不相同
     * @param mytestCaseNo  测试用例编号
     * @param expected   预期结果
     * @param actual   实际结果
     * @param message   打印到log信息
     * @param driver   驱动
     */
    public  void verifyNotEquals(String caseNo, Object expectedObject, WebElement actualWebElement,String message,WebDriver driver){
        
        try{
        	assCaseNo=caseNo;
        	TestBase.modelTotalAsser++;

//        	进行断言
            Assert.assertNotEquals(expectedObject, DataHandle.getElementText(actualWebElement));
//            断言成功日志输出
     	   Log.logInfo(getOutputStr(message)+getRes(true, expectedObject, actualWebElement), GetClassMethodName());
        	}
        catch(Error e)
        {
        	TestBase.commonlyNo++;
        	TestBase.modelAsserFail++;
//        	失败操作
            errors.add(e);
        	flag = false; 
        	String snapShootName= getSnapFileName(false);
//			执行截图操作			
			TestBase.screenShots.takeScreenshots(actualWebElement, snapShootName);			
//			使用log写入report及log文件中：
			Log.logWarn(getOutputStr(message)+getRes(false, expectedObject, actualWebElement), GetClassMethodName(), snapShootName);
		
        }
    } 
   

 /**
  * 判断页面元素是否存在，用于判断对象出现的情况
  * @param element 页面对象
  * @param message 输出语句
  * @param driver weblement
  */
    public  void webElementIsNotNull(String caseNo, WebElement webElement,String message,WebDriver driver){
        try{
        	assCaseNo=caseNo;
        	TestBase.modelTotalAsser++;

//        	进行断言
            Assert.assertNotNull(webElement);
           
        	Log.logInfo(getOutputStr(message)+"；测试结果:测试成功!元素已被定位！", GetClassMethodName());				
        }catch(Error e)
        {
        	TestBase.commonlyNo++;
        	TestBase.modelAsserFail++;
        	String snapShootName= getSnapFileName(false);
//			    	失败操作
            errors.add(e);
        	flag = false; 
         	Log.logWarn(getOutputStr(message)+"；测试结果:测试失败!元素未被定位！", GetClassMethodName(), snapShootName);		
        }
    }
    /**
     * 判断页面元素是否存在，用于判断对象销消失情况
     * @param element 页面对象
     * @param message 输出语句
     * @param driver weblement
     */
    public  void webElementIsNull(String caseNo,WebElement webElement,String message,WebDriver driver){
    
            try{
            	assCaseNo=caseNo;
            	TestBase.modelTotalAsser++;

//            	进行断言
                Assert.assertNull(webElement);
               
            	Log.logInfo(getOutputStr(message)+"；测试结果:测试成功!元素消失！", GetClassMethodName());				
            }catch(Error e)
            {
            	TestBase.commonlyNo++;
            	TestBase.modelAsserFail++;
//    			     	失败操作
            	String snapShootName= getSnapFileName(false);
                errors.add(e);
            	flag = false; 
//            	执行截图操作			
    			TestBase.screenShots.takeScreenshots(webElement,snapShootName);			
//    			使用log写入report及log文件中：
    			Log.logWarn(getOutputStr(message)+"；测试结果:测试失败!元素还在页面上！", GetClassMethodName(), snapShootName);
            }

    }  
    
//	判断按钮是否可以点击
	public  void buttonisDisplayed(String mytestCaseNo,WebElement element ,String message,WebDriver driver){
		boolean isDisplayed = false;
		try{		
			TestBase.modelTotalAsser++;
			 if (TestBase.testCaseNo.equals(mytestCaseNo))
	      	   {
//	      		   如果传入的用例编号与当前一致，增加步骤不改用例编号
//	      		   TestBase.testCaseNo=mytestCaseNo;
	             	step++;	
	      	   }
	             else {
//	          	   获得当前编号，重置步骤
	          	   TestBase.testCaseNo=mytestCaseNo;
	              	step=0;
	 			}
			isDisplayed = element.isDisplayed();
			Assert.assertTrue(isDisplayed);
			Log.logInfo("测试用例："+TestBase.testCaseNo+"步骤:"+step+"-"+message+"；测试结果:测试成功！按钮可点击！", GetClassMethodName());	
		}catch(Error e){
			TestBase.commonlyNo++;
			TestBase.modelAsserFail++;
//	     	失败操作
            errors.add(e);
        	flag = false; 
         	Log.logWarn(getOutputStr(message)+"；测试结果:测试失败!按钮不可点击", GetClassMethodName(), getSnapFileName(false));		

		}
		
	}	
	
	public  void buttonNotDisplayed(String mytestCaseNo,WebElement element ,String message,WebDriver driver){
		boolean isDisplayed = false;
		try{		
			TestBase.modelTotalAsser++;
			 if (TestBase.testCaseNo.equals(mytestCaseNo))
	      	   {
//	      		   如果传入的用例编号与当前一致，增加步骤不改用例编号
//	      		   TestBase.testCaseNo=mytestCaseNo;
	             	step++;	
	      	   }
	             else {
//	          	   获得当前编号，重置步骤
	          	   TestBase.testCaseNo=mytestCaseNo;
	              	step=0;
	 			}
			isDisplayed = element.isDisplayed();
			Assert.assertFalse(isDisplayed);
			Log.logInfo("测试用例："+TestBase.testCaseNo+"步骤:"+step+"-"+message+"；测试结果:测试成功！按钮无法点击！", GetClassMethodName());	
		}catch(Error e){
			TestBase.commonlyNo++;
			TestBase.modelAsserFail++;
//			  	失败操作
	            errors.add(e);
	        	flag = false; 
	         	Log.logWarn(getOutputStr(message)+"；测试结果:测试失败!按钮可点击", GetClassMethodName(), getSnapFileName(false));
		}	
	}
//	判断按钮是否可以点击
	public  void isTrue(String testCaseNo,Boolean object ,String message,WebDriver driver){
		boolean isDisplayed = false;
		try{		
			TestBase.modelTotalAsser++;
			 if (TestBase.testCaseNo.equals(testCaseNo))
	      	   {
//	      		   如果传入的用例编号与当前一致，增加步骤不改用例编号
//	      		   TestBase.testCaseNo=mytestCaseNo;
	             	step++;	
	      	   }
	             else {
//	          	   获得当前编号，重置步骤
	          	   TestBase.testCaseNo=testCaseNo;
	              	step=0;
	 			}
			
			Assert.assertTrue(object);
			Log.logInfo("测试用例："+TestBase.testCaseNo+"步骤:"+step+"-"+message+"；测试结果:测试成功！对象为真！", GetClassMethodName());	
		}catch(Error e){
			TestBase.commonlyNo++;
			TestBase.modelAsserFail++;
			 errors.add(e);
//				定义截图文件名变量
				String screenShotsfileName;
//				创建截图对象实例
				ScreenShots myScreenShots=new ScreenShots(driver);		
//			执行截图操作。得到截图文件名
//				screenShotsfileName="测试用例编号："+TestBase.testCaseNo+":"+myScreenShots.takeScreenshot(TestBase.testCaseNo+":"+step);	
//				使用log体系输出:预期结果+实际结果+文件名称
//			 ErrorLog.logError("测试用例："+TestBase.testCaseNo+"步骤:"+step+"-"+message+"；测试结果:测试失败！对象为假！失败截图名："+screenShotsfileName, GetClassMethodName()); 
			 flag = false;
		}
		
	}	
	
    }