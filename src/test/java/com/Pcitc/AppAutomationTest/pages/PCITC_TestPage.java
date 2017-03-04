package com.Pcitc.AppAutomationTest.pages;

import org.openqa.selenium.WebElement;

import com.Pcitc.AppAutomationTest.base.TestBase;
import com.Pcitc.AppAutomationTest.pagesHelper.Location;

public class PCITC_TestPage extends TestBase 
{
	protected WebElement element=null;
	protected void getOB()
	{
		element=getElemntByYaml(Location.TextView_Ptext, true, true, "差旅", "");
	}

}
