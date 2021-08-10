package Demo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
public class Capability {

	public static AndroidDriver<AndroidElement> capabilities() throws IOException {
		DesiredCapabilities cap = new DesiredCapabilities();
		  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "sagar");
		  cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		  cap.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
		  cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, "C:\\Users\\0013OO744\\Downloads\\chromedriver_win32\\chromedriver.exe");
		  AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),cap);
		  //webdriver driver = new Chromedriver ();
		  return driver;
	}

}
