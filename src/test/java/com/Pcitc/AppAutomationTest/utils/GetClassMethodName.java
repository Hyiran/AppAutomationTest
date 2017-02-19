package com.Pcitc.AppAutomationTest.utils;


public class GetClassMethodName 
{
	
	public String classMethodeName="";
	public String clasName="";
	public String MethodeName="";
	public static  String GetClassMethodName()
	{	
		
			StackTraceElement[] stackTraceElements=Thread.currentThread().getStackTrace();
			String className=stackTraceElements[2].getClassName();
			int index=className.lastIndexOf(".");
			index++;
			className =className.substring(index, className.length())+"."+stackTraceElements[2].getMethodName()+"."+stackTraceElements[2].getLineNumber()+":";
			return className;
	
		/*
		classMethodeName= this.getClass().getSimpleName()+"."+Thread.currentThread().getStackTrace()[2].getMethodName();
		clasName=this.getClass().getSimpleName();
		MethodeName=Thread.currentThread().getStackTrace()[2].getMethodName();
	  return classMethodeName+":";
	  **/
	}

}

