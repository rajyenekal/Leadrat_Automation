package Utilities;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        Throwable exception = result.getThrowable();
        if (exception != null) {
           System.out.println("Exception: " + exception.getMessage());
            exception.printStackTrace();
        }
    }

    // Implement other methods if needed (e.g., onTestStart, onTestSuccess, onTestSkipped, etc.)
}
