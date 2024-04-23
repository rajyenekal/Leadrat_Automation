package testCases;

import org.testng.annotations.Test;

import pomPages.AddDataPage;
import pomPages.LoginPage;
import test.base.DummyBase;

public class Tc0002_AddData extends DummyBase{
	
	@Test
	public void addingData() throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		AddDataPage adp = new AddDataPage(driver);
		lp.Login(UserName, pwd);
		logger.info("Logged in Successfully");
		adp.navigatetoData("Datatest", "9876543212", "raj@gmail.com");
		adp.fillData("Direct", "office", "Rajaneesh K B");
		adp.moreData("350", "Sq. Feet", "2 BHK VILLA", "Rental villa", "ANAROCK PROPERTIES", "Business");
		adp.addData("Raj enterprises", "CEO", "Amit Pandey", "Amit Pandey", "Majama", "Rajaneesh", "8765432190", "HSR", "Automated Data");
		Thread.sleep(2000);
		
	}

}
