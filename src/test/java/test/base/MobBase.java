package test.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;



public class MobBase {
	
	public static AppiumDriver driver;
	protected static Logger logger;
	
	@BeforeClass
	public void setup() throws MalformedURLException , InterruptedException{
	    logger = LogManager.getLogger(MobBase.class);
	    
	    DesiredCapabilities cap = new DesiredCapabilities();
	    cap.setCapability("automationName", "uiautomator2");
	    cap.setCapability("platformName", "Android");
	    cap.setCapability("deviceName", "moto g52");
	    cap.setCapability("udid", "ZD2225C4M3");
	    cap.setCapability("appPackage", "com.leadrat.black.mobile.droid");
	    cap.setCapability("appActivity", "com.leadrat.black.mobile.droid.SplashActivity");
	    cap.setCapability("newCommandTimeout", 300);
	    cap.setCapability("appium:debugLogSpacing", true);
	    
	    URL url = new URL("http://127.0.0.1:4723/");
	    
	    driver = new AndroidDriver(url, cap); // Using the class-level driver variable
	    
	    logger.info("Session id " + driver.getSessionId());
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}


		@AfterClass
		public void teardown() {
			driver.quit();
		}

		
		 public static String captureScreenshot(String methodName) throws IOException {
		        try {
		            TakesScreenshot screenshot = (TakesScreenshot) driver;
		            File source = screenshot.getScreenshotAs(OutputType.FILE);

		            String timeStamp = new SimpleDateFormat("dd-MM-yyyy_hh.mm.ss a").format(new Date());

		            timeStamp = timeStamp.replace("/", "_");

		            String destFilePath = "Screenshots/" + methodName + "_" + timeStamp + ".png";

		            File destination = new File(destFilePath);
		            org.apache.commons.io.FileUtils.copyFile(source, destination);
		            System.out.println("Screenshot taken: " + destFilePath);

		            return destFilePath;
		        } catch (Exception e) {
		            e.printStackTrace();
		            return "";
		        }
		    }
}
