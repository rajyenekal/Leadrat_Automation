package web.test;

import org.junit.Assert;
import org.testng.annotations.Test;

import pomPages.UpdatesStatusPage;
import test.base.BaseTest;
import test.base.RetryAnalyzer;

public class TC005_Meeting extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void Scheduling_a_Meeting_and_Marking_it_as_Done() throws InterruptedException {
        
    	UpdatesStatusPage usp = new UpdatesStatusPage(driver);

        usp.ScheduleStatus("Schedule Meeting", "Status updated");
        logger.info("Meeting Scheduled successfully\n");

        boolean isMeetingUpdated = usp.updatemeeting("Meeting", "Rajaneesh", "9876517897", "Meeting Done");
        
        Assert.assertTrue("Meeting should be updated successfully", isMeetingUpdated);
        if (isMeetingUpdated) {
            logger.info("Scheduled Meeting updated successfully\n");
        } else {
            logger.info("Unable to update meeting\n");
        }
    }
}
