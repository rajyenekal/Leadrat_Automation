package web.test;

import org.junit.Assert;
import org.testng.annotations.Test;

import pomPages.UpdatesStatusPage;
import test.base.BaseTest;
import test.base.RetryAnalyzer;

public class TC005_Meeting extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void callbackStatus() throws InterruptedException {
        UpdatesStatusPage usp = new UpdatesStatusPage(driver);

        usp.ScheduleStatus("Schedule Meeting", "Status updated");
        logger.info("Status updated successfully\n");

        boolean isMeetingUpdated = usp.updatemeeting("Meeting", "Rajaneesh", "9876517897", "Meeting Done");
        
        Assert.assertTrue("Meeting should be updated successfully", isMeetingUpdated);
        if (isMeetingUpdated) {
            logger.info("Meeting updated successfully\n");
        } else {
            logger.info("Unable to update meeting\n");
        }
    }
}
