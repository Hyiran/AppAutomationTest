package com.Pcitc.AppAutomationTest;

import org.testng.annotations.Test;

import com.Pcitc.AppAutomationTest.utils.ConnectMySQL;
import com.Pcitc.AppAutomationTest.utils.Log;

import java.util.HashMap;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest
{
	@Test
	public void t1()
	{
		 ConnectMySQL mysql=new ConnectMySQL();
		 mysql.connect("localhost:3306/xiaoying", "root", "root");
//		 mysql.getSqlResault("update testdata set ESSP_GongShi='分公司工会' where number=1",false);  	
		 List<HashMap<String, String>> rs =mysql.getSqlResault("SELECT * from testdata ",true);
		 Log.logInfo(rs, "");
	}
}
