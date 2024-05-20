package mob.test;

import org.testng.annotations.Test;

import mobPages.loginScreen;
import test.base.MobBase;

public class TC0001_mob extends MobBase{
	
	@Test
	public void loginTest() {
		
		loginScreen ls = new loginScreen(driver);
		ls.login("blackrock", "Sharath", "Sharath@912");
		logger.info("Login Successful");
		
	}

}
