package web.test;

import org.junit.Assert;
import org.testng.annotations.Test;

import pomPages.UpdatesStatusPage;
import test.base.BaseTest;
import test.base.RetryAnalyzer;

public class TC006_SiteVisit extends BaseTest {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void Scheduling_a_SiteVisit_and_Marking_it_as_Done() throws InterruptedException {
		UpdatesStatusPage usp = new UpdatesStatusPage(driver);
		
		usp.ScheduleStatus("Schedule Site Visit", "Status updated");
		logger.info("Site-Visit Scheduled Successfully\n");
		
        boolean isMeetingUpdated = usp.updatemeeting("Site", "Rajaneesh", "9876517897", "Meeting Done");
	        
	        Assert.assertTrue("Site-Visit should be updated successfully", isMeetingUpdated);
	        if (isMeetingUpdated) {
	            logger.info("Scheduled Site-Visit updated successfully\n");
	        } else {
	            logger.info("Unable to update Site-Visit\n");
	        }

	}
}
