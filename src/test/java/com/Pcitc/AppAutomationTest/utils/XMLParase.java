package com.Pcitc.AppAutomationTest.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;

/**
 * 解析XML文件
 * @author Administrator
 *
 */
public class XMLParase extends  GetClassMethodName {
private  Document  document;
private  String filePath;
/**
 * 构造函数初始 加载文件
 * @param filePath
 */
public XMLParase(String filePath)
	{

	this.filePath=filePath;
	this.Load(this.filePath);
	}

/**
 * 创建file对象
 * @param filePath 文件路径
 */
public void Load(String filePath)
{
	File file=null;;
try {
	file =new File(filePath);
} catch (Exception e) {
	ErrorLog.logError("xml路径错误，路径地址:"+filePath,GetClassMethodName());
}

	if(file.exists())
	{	  
			SAXReader saxReader =new SAXReader();
				try 
			{
				  document =saxReader.read(file);
			} catch (DocumentException e)
			{
				ErrorLog.logError("xml 标签解析错误！请检查文件，文件为："+filePath,GetClassMethodName());		
			}
	}
	
}
/**
 * 得到一级对象
 * @param elementPath
 * @return
 */
public Element getElementObject(String elementPath)
	{
	try{
	 return (Element) document.selectSingleNode(elementPath);
	}
	catch(Exception e)
		{
		ErrorLog.logError("节点获取异常请检查文件："+elementPath,GetClassMethodName());
//		Log.logError(this.getClass().getSimpleName()+".getElementObject：common节点获取异常请检查文件");
		return null;
		}
	}
/**得到一级对象文本内容
 * 
 */
public String getElementText(String elementPath)
{	

   Element element =this.getElementObject(elementPath);
    if(element!=null)
	    {
	    	return element.getTextTrim();
	    }
    else
	    {
    		ErrorLog.logError("XMLParase.getElementText-"+elementPath+"找不到定位元素",GetClassMethodName());
    		String message="找不到元素";
	    	return message;
	    }
    }
/**
 * 
 * @param elementPath 一级对象的标签名
 * @return
 */
@SuppressWarnings("unchecked")
public List<Element> getElementObjects(String elementPath)
{
	try
		{
			return document.selectNodes(elementPath);
		}
	catch(Error e )
	{
		
		ErrorLog.logError(this.getClass().getSimpleName()+".getElementObjects:获得与函数同名节点数据错误，请检查文件",GetClassMethodName());
		return null;
	}
}
/**
 * 
 * @param element
 * @return
 */
@SuppressWarnings("unchecked")
public Map<String, String> getChildrenInfoByElement(Element element)
{
	try{
			Map<String, String> map=new HashMap<String, String>();
			List<Element> children =element.elements();
			for(Element e : children)
			{
			map.put(e.getName(),e.getText());	
			}
	return map;	
		}
	catch(Error e)
	{
//		Log.logError(e.getMessage());
		ErrorLog.logError(this.getClass().getSimpleName()+".getChildrenInfoByElement:common子节点对象获取异常请检查文件",GetClassMethodName());
		return null;
	}
}
@Test(description="测试读取xml文件数据并复制到list中")
public void  test1()
{
	 Map<String, String> commonMap;
	XMLParase xp=new  XMLParase("./PageTitle/Login.xml");
	Element element= xp.getElementObject("/*/common");
	commonMap = xp.getChildrenInfoByElement(element);
	List<Element> elements=xp.getElementObjects("/*/title");

	Map<String, String>	 mergeCommon = null;
	for(int i=elements.size()-1;i>-1;i--)
	{
		mergeCommon =this.getMergeMapData(xp.getChildrenInfoByElement(elements.get(i)), commonMap);
	}
	ArrayList<String>  list =new ArrayList<String>();
	  int x=0;
	  for (Map.Entry<String, String> entry : mergeCommon.entrySet()) {
		
		 list.add(entry.getValue());
		 x++;
	  }
	System.out.println(list.get(0)+list.get(1)+list.get(2));
	
}
private Map<String, String>	getMergeMapData(Map<String, String> map1,Map<String,String> map2)
{
Iterator<String> it = map2.keySet().iterator();
while(it.hasNext())
	{
		String key =it.next();
		String value=map2.get(key);
		if(!map1.containsKey(key))
		{
			map1.put(key, value);
		}
	}
return map1;
}

}