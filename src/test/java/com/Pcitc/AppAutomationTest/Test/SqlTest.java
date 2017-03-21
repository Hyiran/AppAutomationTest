package com.Pcitc.AppAutomationTest.Test;

import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.utils.ConnectMySQL;
import com.Pcitc.AppAutomationTest.utils.Log;

public class SqlTest {

	public static void main(String[] args) {
	
//		创建链接
			 ConnectMySQL mysql=new ConnectMySQL();
			 mysql.connect("localhost:3306/xiaoying", "root", "root");
	
			
//			 执行查询
			 List<HashMap<String, String>> rs =mysql.getSqlResault("SELECT *  from data  ",true);
			 String data=rs.get(0).get("ESSP_FeiYongBaoXiaoTest");
			 System.out.println("当前值："+data);
	
			 
//			 执行 增删改
			 mysql.getSqlResault("update data set ESSP_FeiYongBaoXiaoTest='2j' where datano=1",false);  
			 rs =mysql.getSqlResault("SELECT *  from data  ",true);
			 data=rs.get(0).get("ESSP_FeiYongBaoXiaoTest");
			 System.out.println("修改后值："+data);
	}

}
