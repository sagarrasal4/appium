package Demo;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.touch.LongPressOptions;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

import java.awt.event.KeyEvent;
public class Demohybrid extends Capability {
	
	//AndroidDriver DR;
	AndroidDriver<AndroidElement> DR;
	
	
	@BeforeTest
	public void setup() throws MalformedURLException
	{
		DR=capabilities();
		DR.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test(enabled = false)
	public void  Test1()
	{
		DR.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sagar");
		DR.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
	
		//select is only for UI
		//Select s = new Select(DR.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")))  ;
		//s.selectByVisibleText("Australia");
		
		 //i have to work with drop down
        DR.findElement(By.id("android:id/text1")).click(); 
        DR.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
	DR.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	
	}
	
	
	@Test (enabled = false)
	public void  Test2()
	{
		//DR.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sagar");
		DR.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
	
		 //i have to work with drop down
        DR.findElement(By.id("android:id/text1")).click(); 
        DR.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
	DR.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	
	
	//to read pop up message if it comes (comment 2 lines to enter name and click so it will show popup)
	String message =DR.findElement(By.xpath("//android.widget.toast[1]")).getText();
	System.out.println(message);
	Assert.assertEquals(message, "Please enter your name");
	
	}
	
	@Test (enabled = false)
	public void  Test3() throws InterruptedException
	{
		DR.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sagar");
		DR.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
			 //i have to work with drop down
        DR.findElement(By.id("android:id/text1")).click(); 
        DR.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();
	DR.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	//by index
	
	DR.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	//click 2nd one as 1st one gets disables after adding , index of 2nd will be 0
	DR.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
	DR.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	
	Thread.sleep(3000);
	String a =DR.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
	a = a.substring(1);       
	Double amount1value = Double.parseDouble(a);        
	System.out.println(amount1value); 
	String b =DR.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
    b = b.substring(1);         
    Double amount2value = Double.parseDouble(b);    
    System.out.println(amount2value); 
	String total = DR.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
	total = total.substring(2);       
	Double Totalvalue = Double.parseDouble(total);        
	System.out.println(Totalvalue);
    //i have to sum it and check if it is equal     
	Double TotalsumofValue = amount1value+amount2value;       
	System.out.println(TotalsumofValue);              
	Assert.assertEquals(Totalvalue, TotalsumofValue);
	
	}
	
	@Test (enabled = true)
	public void test4() throws InterruptedException
	{
		
		DR.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");     
		//driver.findElement(By.xpath("//*[@id='com.androidsample.generalstore:id/nameField']")).sendKeys("Niharika");        
		DR.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();      
		//i have to work with drop down         
		DR.findElement(By.id("android:id/text1")).click();      
		DR.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))").click();    
		DR.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click(); 
		Thread.sleep(8000);           
		DR.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Converse All Star\"))");              
		
		int count = DR.findElements(By.id("com.androidsample.generalstore:id/productName")).size();             
		

for(int i=0;i<count;i++)        
{             
	String name = DR.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();          
	if(name.equals("Converse All Star"))            
	{                 
		DR.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();        
	break;   
	}     
	} 
DR.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

Thread.sleep(3000);

DR.findElement(By.className("android.widget.CheckBox")).click();


TouchAction T = new TouchAction(DR);


WebElement a= DR.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));


T.longPress(longPressOptions().withElement(element(a)).withDuration(ofSeconds(3))).release().perform();


//Close the terms
DR.findElement(By.id("android:id/button1")).click();
DR.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
Thread.sleep(9000);

/*
//Long press on terms
WebElement terms = DR.findElementById("com.androidsample.generalstore:id/termsButton");
t.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(3))).release().perform();

//Close the terms
DR.findElement(By.id("android:id/button1")).click();

//Click on visit website
DR.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
*/

//navigated to browser and work with browser 
Set<String> contextNames = DR.getContextHandles();
for (String contextName : contextNames) {
    System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1

       }
   
   DR.context("WEBVIEW_com.androidsample.generalstore"); // to switch to web or native app view
    DR.findElement(By.xpath("//*[@name='q']")).sendKeys("IBM");
    //i want to click on enter
    DR.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
   // DR.pressKey(new KeyEvent(AndroidKey.BACK));
DR.context("NATIVE_APP");

}

}

	
	


