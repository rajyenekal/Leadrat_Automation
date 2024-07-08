package web.test;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.RandomDataUtil;
import pomPages.AddLeadPage;
import test.base.BaseTest;


public class TC001_AddLead extends BaseTest{

    @Test
	public void addingLead() throws InterruptedException, IOException {
		AddLeadPage alp = new AddLeadPage(driver);
		
		alp.clickaddLeadBtn();
		
		String userName= RandomDataUtil.getName();
		String email = RandomDataUtil.getEmail(userName);
		long phoneNo = RandomDataUtil.getPhoneNo();

		alp.enterData(userName, phoneNo, email);
		logger.info("Entered "+userName+"  "+phoneNo+" "+email+"");
		alp.otherdata("Ahex", "hsr", "6000000", "8000000");
		alp.anotherData("1500");
		alp.propType();
		alp.moreData("House", "VILLA", "Aamor", "99", "Business", "Leadrat", "QA", "Automated Lead");
		
		if(alp.saveLead(userName)) {
			logger.info("Lead Added Successfully");
		}
		else {
			logger.info("Failed to Add Lead");

		}
	}
    
}
