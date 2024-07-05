package web.test;

import org.testng.annotations.Test;

import Utilities.RandomDataUtil;
import pomPages.AddDataPage;
import pomPages.LoginPage;
import test.base.BaseTest;

public class TC002_AddData extends BaseTest{
	
	@Test
	public void addingData() throws InterruptedException {
		
		LoginPage lp = new LoginPage(driver);
		AddDataPage adp = new AddDataPage(driver);
		lp.Login(UserName, pwd);
		
		String userName= RandomDataUtil.getName();
		String email = RandomDataUtil.getEmail(userName);
		long phoneNo = RandomDataUtil.getPhoneNo();
		String mobNo = Long.toString(phoneNo);

		
		
		logger.info("Logged in Successfully");
		adp.navigatetoData(userName, mobNo, email);
		adp.fillData("Direct", "office", "Rajaneesh K B");
		adp.moreData("350", "Sq. Feet", "2 BHK VILLA", "Rental villa", "Anarock properties", "Business");
		adp.addData("Raj enterprises", "CEO", "Amit Pandey", "Amit Pandey", "Majama", "Rajaneesh", "8765432190", "HSR", "Automated Data",userName);
		logger.info("Data added Successfully");

	}

}
