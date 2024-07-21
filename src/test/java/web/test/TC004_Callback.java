package web.test;

import org.testng.annotations.Test;

import pomPages.UpdatesStatusPage;
import test.base.BaseTest;

public class TC004_Callback extends BaseTest {

	@Test
	public void callbackStatus() throws InterruptedException {
		UpdatesStatusPage usp = new UpdatesStatusPage(driver);
		usp.ScheduleStatus("Callback", "Status updated");
		logger.info("Status Updated Successfully\n");
	}
}
