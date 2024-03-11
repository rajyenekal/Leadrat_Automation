package Utilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;

public class ScreenshotListener extends TestListenerAdapter {

    private WebDriver driver;

    public ScreenshotListener(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        captureScreenshot(result.getMethod().getMethodName());
    }

    private void captureScreenshot(String methodName) {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            String destFilePath = "Screenshots/" + methodName + ".png";
            File destination = new File(destFilePath);
            org.apache.commons.io.FileUtils.copyFile(source, destination);
            System.out.println("Screenshot taken: " + destFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
