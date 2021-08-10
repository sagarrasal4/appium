package Native;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.ElementOption;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import static java.time.Duration.ofSeconds;

public class Demo extends Capability{
	
	AndroidDriver<AndroidElement> DR ;
	
	@BeforeTest
	public void setup() throws IOException
	{
	DR=capabilities();
	DR.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(enabled = false)
	public  void Teatcase1() throws InterruptedException
	{
		DR.findElementByAccessibilityId("Preference").click();
		//DR.findElement(MobileBy.AccessibilityId("Preference")).click();
		
		DR.findElementByAccessibilityId("3. Preference dependencies").click();
		DR.findElement(By.id("android:id/checkbox")).click();
		//below lines perform same operation
		//DR.findElement(By.xpath("//*[@text=;\'WiFi Setting']")).click();
		DR.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();
		//DR.findElementByAndroidUIAutomator("text(\"WiFi Setting\")").click();
		DR.findElement(By.className("android.widget.EditText")).sendKeys("sagar");
		//to hide keuboard
		DR.hideKeyboard();
		//get element by index-- for cancel button
		DR.findElements(By.className("android.widget.Button")).get(0).click();
		//to go to back screen also to press any key on mobile.
		DR.pressKey(new KeyEvent (AndroidKey.BACK));
		Thread.sleep(3000);
	}
	
		@Test (enabled = false)
		public void testcase2()
		{
			DR.findElementByAccessibilityId("Views").click();
			
			//DR.findElementByAccessibilityId("Expandable Lists").click();
			
			//tap option methood
			WebElement elem=DR.findElementByAccessibilityId("Expandable Lists");
			
				TouchAction t= new TouchAction(DR);
			      t.tap(tapOptions().withElement(element(elem))).perform();
			      DR.findElementByAccessibilityId("1. Custom Adapter").click();
			      WebElement ele3 = DR.findElementByAndroidUIAutomator("text(\"People Names\")");
			      t.longPress(longPressOptions().withElement(element(ele3)).withDuration(ofSeconds(3))).release().perform();
			    System.out.println(DR.findElement(By.className("android.widget.FrameLayout")).get(0).getText());
		
		}
		
	
	@Test(enabled = false)
	public void test3()
	{
		//notification
		DR.openNotifications();
		}
	
	@Test (enabled = false)
		public void test4()
	{
		//notification
		DR.findElementByAccessibilityId("Views").click();
		//we want to scroll till last
		//java script will run only for web apps , not for native apps
		//scrolling till particular element 
		DR.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))").click();;
		
		}
	
//swipe and change clock
	@Test (enabled = false)
		public void test5()
		{
		DR.findElementByAccessibilityId("Views").click();
		DR.findElementByAccessibilityId("Date Widgets").click();
		DR.findElementByAccessibilityId("2. Inline").click();
		//DR.findElement(MobileBy.AccessibilityId("2. Inline")).click();
        DR.findElement(MobileBy.AccessibilityId("3")).click();
    WebElement btn1 =    DR.findElement(MobileBy.AccessibilityId("15"));
   WebElement btn2 =DR.findElement(MobileBy.AccessibilityId("45"));
   TouchAction t = new TouchAction(DR);
   t.longPress(longPressOptions().withElement(element(btn1)).withDuration(ofSeconds(3))).moveTo(element(btn2)).release().perform();
		}
	
	
	//drag and drop
	@Test 
	public void test6()
	{
	DR.findElementByAccessibilityId("Views").click();
	DR.findElementByAccessibilityId("Drag and Drop").click();
	
WebElement btn1 =    DR.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
WebElement btn2 =DR.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
TouchAction t = new TouchAction(DR);
t.longPress(longPressOptions().withElement(element(btn1)).withDuration(ofSeconds(3))).moveTo(element(btn2)).release().perform();
	}

    
}
