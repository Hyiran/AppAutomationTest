package com.Pcitc.AppAutomationTest.Test;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.Pcitc.AppAutomationTest.utils.Log;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;

public class iosTest {
	
	private AppiumDriver     driver;


	  private List<Integer>    values;


	  private static final int MINIMUM = 0;
	  private static final int MAXIMUM = 10;


	  private Point getCenter(final WebElement element)
	  {

	    final Point upperLeft = element.getLocation();
	    final Dimension dimensions = element.getSize();
	    return new Point(upperLeft.getX() + dimensions.getWidth() / 2,
	        upperLeft.getY() + dimensions.getHeight() / 2);
	  }


	  private void populate() {
	    // populate text fields with two random number
	    final List<WebElement> elems = driver.findElements(By
	        .className("UIATextField"));
	    final Random random = new Random();
	    for (final WebElement elem : elems) {
	      final int rndNum = random.nextInt(MAXIMUM - MINIMUM + 1) + MINIMUM;
	      elem.sendKeys(String.valueOf(rndNum));
	      values.add(rndNum);
	    }
	  }


	  @BeforeClass
	  public void setUp() throws Exception {
	    // set up appium


	    final DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	    capabilities.setCapability("platformVersion", "10.1");
	    capabilities.setCapability("platformName", "iOS");
	    capabilities.setCapability("deviceName", "iPhone 6 plus");
	    capabilities.setCapability("app", "com.beijingranqi.distribution");
	    driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),
	        capabilities);
	    values = new ArrayList<Integer>();
	  }


	  @AfterClass
	  public void tearDown() throws Exception
	  {
	    driver.quit();
	  }


	  @Test
	  public void testHideKeyboard() throws Exception
	  {
	    Log.logInfo("测试被执行到了", "222");

	  }

    }


