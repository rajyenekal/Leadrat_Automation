package test.base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager1 implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String repName = "Test-Report-" + timeStamp + ".html";

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
        // Add image
        addImageToReport("leadrat_logo.jpg");
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.createNode(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, "Test Failed");
        test.log(Status.FAIL, result.getThrowable().getMessage());
        
        // Add screenshot for failure
        if (!isAPITest(result)) {
            try {
                String screenshotPath = BaseTest.captureScreenshot(result.getName());
                File file = new File(screenshotPath);
                String absolutePath = file.getAbsolutePath();
                test.addScreenCaptureFromPath(absolutePath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // Add image
        addImageToReport("leadrat_logo.jpg");
    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.createNode(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, "Test Skipped");
        test.log(Status.SKIP, result.getThrowable().getMessage());
        // Add image
        addImageToReport("leadrat_logo.jpg");
    }

    public void onFinish(ITestContext testContext) {
        extent.flush();
        
    }

    private boolean isAPITest(ITestResult result) {
        String className = result.getTestClass().getName();
        return (" " + className.toLowerCase() + " ").contains("api");
    }
    
    private void addImageToReport(String imageName) {
        String imagePath = "./src/test/resources/image/" + imageName;
        File imageFile = new File(imagePath);
        
        if (imageFile.exists()) {
            try {
                String absolutePath = imageFile.getAbsolutePath();
                // Modify the HTML content to include the image at the top of the report
                test.log(Status.INFO, "<div align='center'><img src='" + absolutePath + "' width='25%' height='25%'/></div>");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Image file not found: " + imagePath);
        }
    }

   
   
    
}
