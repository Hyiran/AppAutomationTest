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
    public static boolean flag = true;
    public  String caseNO="";
    public  int step=1;
    public static List<Error> errors = new ArrayList<Error>();
    private  String outPutinfor="";
    private  String snapShootPath="";
    private  String testResault="";
    private String  getOutputStr(String message ) 
    {
    	 outPutinfor="测试用例："+caseNO+"-步骤:"+step+"-测试"+message+"是否正确";
    	 return outPutinfor;
	}
    private String  getSnapFileName( boolean pinString) 
    {
    	if (pinString) {
    		snapShootPath="；截图文件："+caseNO+"-步骤"+step;
        	return snapShootPath;
		}
    	else {
    		snapShootPath= caseNO+"-步骤"+step;
        	return snapShootPath;
		}
    
	}
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
     * 测试2个对象是否不相同
     * @param mycaseNo  测试用例编号
     * @param expected   预期结果
     * @param actual   实际结果
     * @param message   打印到log信息
     * @param driver   驱动
     */
    public  void verifyNotEquals(String mycaseNo,Object  expected, WebElement actual,String message,WebDriver driver){
        
    	try{
        	   if (caseNO.equals(mycaseNo))
        	   { 
//        		   如果传入的用例编号与当前一致，增加步骤不改用例编号
//        		   caseNO=mycaseNo;
               	step++;	
        	   }
               else {
//            	   获得当前编号，重置步骤
            	   caseNO=mycaseNo;
                	step=0;
   			}
        	  
        	   Log.logInfo(getOutputStr(message)+getRes(true, expected, actual), GetClassMethodName());

     
        }catch(Error e){
        	 errors.add(e);
        	 flag = false;
        	    Assert.assertEquals(expected, DataHandle.getElementText(actual));         
        	
//    			执行截图操作			
    			TestBase.screenShots.takeScreenshots(actual, getSnapFileName(false));			
//    			使用log写入report级log文件中：
//    			体系输出:预期结果+实际结果+文件名称		
    			Log.logWarn(getOutputStr(message)+getRes(false, expected, actual), caseNO, getSnapFileName(false));
//    			
        }
    } 
   
    /**判断元素的预期结果与实际结果是否一致
     * 
     * @param actual 预期结果
     * @param expected 实际结果
     * @param message 判断内容
     * @param dw webdriver 对象
     */
    public  void verifyEquals(String caseNo,Object  expected, WebElement actual,String message,WebDriver driver){
        try{

     	   if (caseNo==caseNO)
     	   {
//     		   如果传入的用例编号与当前一致，增加步骤不改用例编号
     		  caseNO=caseNo;
            	step++;	
     	   }
            else {
//         	   获得当前编号，重置步骤
            	caseNO=caseNo;
            	step=0;
            }
            Assert.assertEquals(actual, expected);

     	   Log.logInfo(getOutputStr(message)+getRes(true, expected, actual), GetClassMethodName());
//            Log.logInfo("测试用例："+caseNO+"步骤:"+step+"-"+message+"；测试结果:测试成功!预期结果："+expected+"；实际结果："+actual, GetClassMethodName());
        }catch(Error e){
            errors.add(e);
        	flag = false;
//			执行截图操作			
			TestBase.screenShots.takeScreenshots(actual, getSnapFileName(false));			
//			使用log写入report级log文件中：
//			体系输出:预期结果+实际结果+文件名称
			Log.logWarn(getOutputStr(message)+getRes(false, expected, actual), GetClassMethodName(), getSnapFileName(false));
		
        }
    }
 /**
  * 
  * @param caseNo  用例编号
  * @param expected  预期结果
  * @param actual  实际结果
  * @param title  对象是否是标题
  * @param name   对象名称
  * @param driver
  */
//    public  void verifyEquals(String caseNo,Object  expected, Object actual,Boolean title,String name,WebDriver driver){
//    	 String  elementName="";
//    	try{
//
//     	   if (caseNo==caseNO)
//     	   {
////     		   如果传入的用例编号与当前一致，增加步骤不改用例编号
//     		  caseNO=caseNo;
//            	step++;	
//     	   }
//            else {
////         	   获得当前编号，重置步骤
//            	caseNO=caseNo;
//            	step=0;
//            }
//     	  
//     	   if(title)
//     	   {
//     		  elementName="标题";
//     	   }
//     	   else
//     	   {
//     		  elementName="数据";
//     	   }
//     		   
//            Assert.assertEquals(actual, expected);
//            Log.logInfo("测试用例："+caseNO+"步骤:"+step+"-测试"+name+elementName+"是否与预期结果一致"+"；测试结果:测试成功!预期结果："+expected+"；实际结果："+actual, GetClassMethodName());
//        }catch(Error e){
//            errors.add(e);
////			定义截图文件名变量
//			String screenShotsfileName;
////			创建截图对象实例
//			ScreenShots myScreenShots=new ScreenShots(driver);		
////			执行截图操作。得到截图文件名
////			screenShotsfileName=myScreenShots.takeScreenshot(caseNO+":"+step);	
////			使用log体系输出:预期结果+实际结果+文件名称
//            String message1="";
////			ErrorLog.logError("测试用例："+caseNO+"步骤:"+step+"-测试"+name+elementName+"是否与预期结果一致"+"；测试结果:测试失败!预期结果："+expected+"；实际结果："+actual+";失败截图名："+screenShotsfileName, GetClassMethodName()); 		
//			flag = false;
//        }
//    }
 /**
  * 判断页面元素是否存在，用于判断对象出现的情况
  * @param element 页面对象
  * @param message 输出语句
  * @param driver weblement
  */
   /**
    *  
    * @param mycaseNo  测试用例代码
    * @param element  页面对象
    * @param message  
    * @param driver
    */
    public  void webElementIsNotNull(String mycaseNo,Object element,String message,WebDriver driver){
        try{

        	 if (caseNO.equals(mycaseNo))
      	   {
//      		   如果传入的用例编号与当前一致，增加步骤不改用例编号
//      		   caseNO=mycaseNo;
             	step++;	
      	   }
             else {
//          	   获得当前编号，重置步骤
          	   caseNO=mycaseNo;
              	step=0;
 			}
            Assert.assertNotNull(element);
        	Log.logInfo("测试用例："+caseNO+"步骤:"+step+"-"+message+"；测试结果:测试成功!元素已被定位！", GetClassMethodName());				
        }catch(Error e){
            errors.add(e);
//			定义截图文件名变量
			String screenShotsfileName;
//			创建截图对象实例
			ScreenShots myScreenShots=new ScreenShots(driver);		
//			执行截图操作。得到截图文件名
//			screenShotsfileName="测试用例："+caseNO+"步骤:"+step+"-"+message+myScreenShots.takeScreenshot(caseNO+":"+step);		
			
//			使用log体系输出:预期结果+实际结果+文件名称
//        	ErrorLog.logError("测试用例："+caseNO+"步骤:"+step+"-"+message+"；测试结果:测试失败！元素没有被找到！失败截图名："+screenShotsfileName, GetClassMethodName()); 
        	flag = false;
        }
    }
    /**
     * 判断页面元素是否存在，用于判断对象销消失情况
     * @param element 页面对象
     * @param message 输出语句
     * @param driver weblement
     */
    public  void webElementIsNull(String mycaseNo,Object element,String message,WebDriver driver){
        try{

        	 if (caseNO.equals(mycaseNo))
      	   {
//      		   如果传入的用例编号与当前一致，增加步骤不改用例编号
//      		   caseNO=mycaseNo;
             	step++;	
      	   }
             else {
//          	   获得当前编号，重置步骤
          	   caseNO=mycaseNo;
              	step=0;
 			}
            Assert.assertNull(element);
        	Log.logInfo("测试用例："+caseNO+"步骤:"+step+"-"+message+"；测试结果:测试成功！元素不存在", GetClassMethodName());				
        }catch(Error e){
            errors.add(e);
//			定义截图文件名变量
			String screenShotsfileName;
//			创建截图对象实例
			ScreenShots myScreenShots=new ScreenShots(driver);		
//			执行截图操作。得到截图文件名
//			screenShotsfileName="测试用例编号："+caseNO+":"+myScreenShots.takeScreenshot(caseNO+":"+step);			
//			使用log体系输出:预期结果+实际结果+文件名称
//        	ErrorLog.logError("测试用例："+caseNO+"步骤:"+step+"-"+message+"；测试结果:测试失败！元素依然在页面上！失败截图名："+screenShotsfileName, GetClassMethodName()); 
        	flag = false;
        }
    }  
     
//	判断按钮是否可以点击
	public  void buttonisDisplayed(String mycaseNo,WebElement element ,String message,WebDriver driver){
		boolean isDisplayed = false;
		try{		

			 if (caseNO.equals(mycaseNo))
	      	   {
//	      		   如果传入的用例编号与当前一致，增加步骤不改用例编号
//	      		   caseNO=mycaseNo;
	             	step++;	
	      	   }
	             else {
//	          	   获得当前编号，重置步骤
	          	   caseNO=mycaseNo;
	              	step=0;
	 			}
			isDisplayed = element.isDisplayed();
			Assert.assertTrue(isDisplayed, message);
			Log.logInfo("测试用例："+caseNO+"步骤:"+step+"-"+message+"；测试结果:测试成功！按钮可点击！", GetClassMethodName());	
		}catch(Error e){
			 errors.add(e);
//				定义截图文件名变量
				String screenShotsfileName;
//				创建截图对象实例
				ScreenShots myScreenShots=new ScreenShots(driver);		
////				执行截图操作。得到截图文件名
//				screenShotsfileName="测试用例编号："+caseNO+":"+myScreenShots.takeScreenshot(caseNO+":"+step);	
//				使用log体系输出:预期结果+实际结果+文件名称
//			 ErrorLog.logError("测试用例："+caseNO+"步骤:"+step+"-"+message+"；测试结果:测试失败！按钮可被点击！失败截图名："+screenShotsfileName, GetClassMethodName()); 
			 flag = false;
		}
		
	}	
	
	
//	判断按钮是否可以点击
	public  void isTrue(String caseNo,Boolean object ,String message,WebDriver driver){
		boolean isDisplayed = false;
		try{		

			 if (caseNO.equals(caseNo))
	      	   {
//	      		   如果传入的用例编号与当前一致，增加步骤不改用例编号
//	      		   caseNO=mycaseNo;
	             	step++;	
	      	   }
	             else {
//	          	   获得当前编号，重置步骤
	          	   caseNO=caseNo;
	              	step=0;
	 			}
			
			Assert.assertTrue(object);
			Log.logInfo("测试用例："+caseNO+"步骤:"+step+"-"+message+"；测试结果:测试成功！对象为真！", GetClassMethodName());	
		}catch(Error e){
			 errors.add(e);
//				定义截图文件名变量
				String screenShotsfileName;
//				创建截图对象实例
				ScreenShots myScreenShots=new ScreenShots(driver);		
//			执行截图操作。得到截图文件名
//				screenShotsfileName="测试用例编号："+caseNO+":"+myScreenShots.takeScreenshot(caseNO+":"+step);	
//				使用log体系输出:预期结果+实际结果+文件名称
//			 ErrorLog.logError("测试用例："+caseNO+"步骤:"+step+"-"+message+"；测试结果:测试失败！对象为假！失败截图名："+screenShotsfileName, GetClassMethodName()); 
			 flag = false;
		}
		
	}	
	
    }