package test.base;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RetryAnalyzer implements IRetryAnalyzer {
	
    private int retryCount = 0;
    private static final int maxRetryCount = 1;
    protected static Logger logger;


    @Override
    public boolean retry(ITestResult result) {
        logger = LogManager.getLogger(RetryAnalyzer.class);

        if (retryCount < maxRetryCount) {
            retryCount++;
            logger.info("Retrying test: " + result.getMethod().getMethodName() +
                    " for the " + retryCount + " time.");
            return true;
        }
        return false;
    }
}
