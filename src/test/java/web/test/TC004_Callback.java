package web.test;

import org.testng.annotations.Test;

import pomPages.UpdatesStatusPage;
import test.base.BaseTest;
import test.base.RetryAnalyzer;

public class TC004_Callback extends BaseTest {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void Updating_LeadStatus_to_Callback() throws InterruptedException {
		
		UpdatesStatusPage usp = new UpdatesStatusPage(driver);
		usp.ScheduleStatus("Callback", "Status updated");
		logger.info("Status Updated Successfully\n");
	}
}
