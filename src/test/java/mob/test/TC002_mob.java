package mob.test;

import org.testng.annotations.Test;

import mobPages.addLeadScreen;
import mobPages.loginScreen;
import test.base.MobBase;

public class TC002_mob extends MobBase {
	
	@Test
	public void loginTest() {
		
		loginScreen ls = new loginScreen(driver);
		ls.login("blackrock", "Sharath", "Sharath@912");
		logger.info("Login Successful");
		
	}
	
	@Test
	public void testLead() {
		addLeadScreen als = new addLeadScreen(driver);
		als.addNewLead("testlead", "9087665912");
	}

}
