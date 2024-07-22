package web.test;

import org.junit.Assert;
import org.testng.annotations.Test;

import pomPages.UpdatesStatusPage;
import test.base.BaseTest;
import test.base.RetryAnalyzer;

public class TC008_Drop extends BaseTest{

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void statusdrop() {
		
        UpdatesStatusPage usp = new UpdatesStatusPage(driver);

		 boolean isStatusUpdated = usp.statusUpdate("Drop", "Dropping the Lead");
	        
	        Assert.assertTrue("Status should be updated successfully", isStatusUpdated);
	        
	        if (isStatusUpdated) {
	            logger.info("Status updated successfully\n");
	        } else {
	            logger.info("Unable to update Status\n");
	        }
	    }
	
}
