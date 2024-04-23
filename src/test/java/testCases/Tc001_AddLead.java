package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.RandomDataUtil;
import pomPages.AddLeadPage;
import pomPages.LoginPage;
import test.base.BaseTest;


public class Tc001_AddLead extends BaseTest{

    @Test
	public void addingLead() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		AddLeadPage alp = new AddLeadPage(driver);
		
		lp.Login(UserName, pwd);
		logger.info("Logged in Successfully");

		alp.clickaddLeadBtn();
		
		String userName= RandomDataUtil.getName();
		String email = RandomDataUtil.getEmail(userName);
		long phoneNo = RandomDataUtil.getPhoneNo();

		alp.enterData(userName, phoneNo, email);
		logger.info("Entered "+userName+"  "+phoneNo+" "+email+"");
		alp.otherdata("amit", "hsr", "6000000", "8000000");
		alp.anotherData("1500");
		alp.propType();
		alp.moreData("House", "VILLA", "New Dawn VILLA ", "99", "Business", "Leadrat", "QA", "Automated Lead");
		
		if(alp.saveLead(userName)) {
			logger.info("Lead Added Successfully");
		}
		else {
			logger.info("Failed to Add Lead");

		}
	}
    
}
