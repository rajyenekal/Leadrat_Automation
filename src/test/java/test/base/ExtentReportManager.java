package test.base;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Utilities.ExtentUtils;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    public String repName;
    public String timeStamp;
    public WebDriver driver;

    public void onStart(ITestContext testContext) {

    	SimpleDateFormat sdf = new SimpleDateFormat("hh.mm.ss a.dd.MM.yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
        timeStamp = sdf.format(new Date());
        repName = "Test-Report-" + timeStamp + ".html";
    	
        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);
        sparkReporter.config().setDocumentTitle("LeadRat Automation Project");
        sparkReporter.config().setReportName("LeadRat Automation Test Report");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Application", "Leadrat Real Estate");
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", "Rajaneesh");
    }

    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.createNode(result.getName());
        test.log(Status.PASS, "Test Passed");

        // Add image if any
        ExtentUtils.addImageToReport(test, "leadrat_logo.jpg");
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.createNode(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, "Test Failed");
        test.log(Status.FAIL, result.getThrowable().getMessage());

        // Log if the test is being retried
        if (result.getAttribute("retryAnalyzer") != null) {
            RetryAnalyzer retryAnalyzer = (RetryAnalyzer) result.getAttribute("retryAnalyzer");
            if (retryAnalyzer.retry(result)) {
                test.log(Status.WARNING, "Retrying the failed test...");
            }
        }

        // Check if the test is an API test
        if (!ExtentUtils.isAPITest(result)) {
            // Capture and embed screenshot if not an API test
            try {
                String screenshotPath;
                if (ExtentUtils.isMobTest(result)) {
                    screenshotPath = MobBase.captureScreenshot(result.getName());
                } else {
                    screenshotPath = BaseTest.captureScreenshot(result.getName());
                }

                File screenshotFile = new File(screenshotPath);
                if (screenshotFile.exists()) {
                    String base64Screenshot = Base64.getEncoder().encodeToString(Files.readAllBytes(screenshotFile.toPath()));
                    test.addScreenCaptureFromBase64String(base64Screenshot);
                } else {
                    System.out.println("Screenshot file not found: " + screenshotPath);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Add image if any
        ExtentUtils.addImageToReport(test, "leadrat_logo.jpg");
    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.createNode(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, "Test Skipped");
        test.log(Status.SKIP, result.getThrowable().getMessage());

        // Add image if any
        ExtentUtils.addImageToReport(test, "leadrat_logo.jpg");
    }

    public void onFinish(ITestContext testContext) {
        extent.flush();

        boolean hasFailedTests = testContext.getFailedTests().size() > 0;
        if (!hasFailedTests) {
        	ExtentUtils.sendEmail("Passed 🏆", repName);
        } else {
        	ExtentUtils.sendEmail("Failed ⚠️", repName);
        }
    }
}
