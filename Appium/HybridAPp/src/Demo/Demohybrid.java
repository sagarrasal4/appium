package Demo;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

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
	public void  Test3()
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
	
	/*String a =DR.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
	System.out.println(a);
	String b =DR.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
	System.out.println(b);*/
	String total = DR.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
    System.out.println(total);
	}
	
	@Test
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
}

	}
	


