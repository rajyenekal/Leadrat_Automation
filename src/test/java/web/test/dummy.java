package web.test;

import org.testng.annotations.Test;

import pomPages.LoginPage;
import test.base.BaseTest;

public class dummy extends BaseTest{

    @Test
	public void dummyrun() {
		System.out.println("Running");
        LoginPage lp=new LoginPage(driver);
		
		if(lp.Login(UserName,pwd)) {
			logger.info("Logged in Successfully");
			lp.logOut();
		}

		else {
			logger.warn("Failed to Log in");
		}
		
		
	}
	
	
}
