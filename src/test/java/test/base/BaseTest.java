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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Utilities.ReadConfigFile;
import pomPages.LoginPage;

public class BaseTest {
    
    public static WebDriver driver;
    protected static Logger logger;
    ReadConfigFile rcf = new ReadConfigFile();
    public String URL = rcf.getappurl();
    public String UserName = rcf.getusernamel();
    public String pwd = rcf.getPwd();

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String br) {
        logger = LogManager.getLogger(BaseTest.class);

        if (br.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (br.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (br.equals("edge")) {
            driver = new EdgeDriver();
        }
        
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(URL);

        LoginPage lp = new LoginPage(driver);
        lp.Login(UserName, pwd);

        logger.info("Logged as "+UserName+" Successfully\n");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
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
