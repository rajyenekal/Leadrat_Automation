package test.base;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Utilities.ReadConfigFile;

public class DummyBase {
	
	public static WebDriver driver;
	protected static Logger logger;
	ReadConfigFile rcf = new ReadConfigFile();
	public String URL= rcf.getappurl();
	public String UserName= rcf.getusernamel();
	public String pwd= rcf.getPwd();

	//@Parameters("browser")
	@BeforeClass
	public void setup() {
		
	    logger = LogManager.getLogger(DummyBase.class);

//		if(br.equals("chrome")) {
//			driver=new ChromeDriver();
//		}
		
//		if(br.equals("firefox")) {
//			driver=new FirefoxDriver();
//		}
//		
//		if(br.equals("edge")) {
//			driver=new EdgeDriver();
//		}
	    
	    driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		driver.manage().window().maximize();
		logger.info("--Navigated to "+URL+" --");
		
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
