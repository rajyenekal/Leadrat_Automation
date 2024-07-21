package web.test;

import org.junit.Assert;
import org.testng.annotations.Test;

import pomPages.UpdatesStatusPage;
import test.base.BaseTest;

public class TC007_NotInterested extends BaseTest{

	@Test
	public void statusNi() {
		
        UpdatesStatusPage usp = new UpdatesStatusPage(driver);

		 boolean isStatusUpdated = usp.statusUpdate("Not Interested", "Not Interested in Lead");
	        
	        Assert.assertTrue("Status should be updated successfully", isStatusUpdated);
	        
	        if (isStatusUpdated) {
	            logger.info("Status updated successfully\n");
	        } else {
	            logger.info("Unable to update Status\n");
	        }
	    }
	
}
