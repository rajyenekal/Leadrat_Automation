package web.test;

import java.io.IOException;

import org.testng.annotations.Test;
import test.base.RetryAnalyzer; // Import RetryAnalyzer

import Utilities.RandomDataUtil;
import Utilities.XLUtils;
import pomPages.AddLeadPage;
import test.base.BaseTest;

public class TC001_AddLead extends BaseTest {
    
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void addingLead() throws InterruptedException, IOException {
        AddLeadPage alp = new AddLeadPage(driver);
        alp.clickaddLeadBtn();
        
        String specifiedHeader = "LeadData";
        XLUtils excelUtil = new XLUtils();
        excelUtil.ExcelUtil(specifiedHeader);

        String userName = RandomDataUtil.getName();
        String email = RandomDataUtil.getEmail(userName);
        long phoneNo = RandomDataUtil.getPhoneNo();

        alp.enterData(userName, phoneNo, email);
        logger.info("Entered " + userName + "  " + phoneNo + " " + email+"\n");

        alp.otherdata(
            excelUtil.getData(1), 
            excelUtil.getData(2),
            excelUtil.getData(3),
            excelUtil.getData(4)
        );
        alp.anotherData(excelUtil.getData(5));
        alp.propType();
        alp.moreData(
            excelUtil.getData(6),
            excelUtil.getData(7),
            excelUtil.getData(8),
            excelUtil.getData(9),
            excelUtil.getData(10),
            excelUtil.getData(11),
            excelUtil.getData(12),
            excelUtil.getData(13)
        );

        if (alp.saveLead(userName)) {
            logger.info("Lead Added Successfully\n");
        } else {
            logger.info("Failed to Add Lead\n");
        }
    }
}
