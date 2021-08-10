package Demo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Demo extends Capability{
	
	AndroidDriver<AndroidElement> DR ;
	
	@BeforeTest
	public void Testcase() throws IOException
	{
	DR=capabilities();
	DR.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	public  void Teatcase1()
	{
		DR.get("http://www.google.com");
		//DR.findElement(By.xpath(null));
		//
		
		JavascriptExecutor js = (JavascriptExecutor)DR;
		WebElement ele= DR.findElement(By.xpath(null));
		js.executeScript("arguments[0]", null);
	}
	
}
