package web.test;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.RandomDataUtil;
import Utilities.XLUtils;
import pomPages.AddDataPage;
import test.base.BaseTest;
import test.base.RetryAnalyzer;

public class TC002_AddData extends BaseTest{
	
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void Creating_a_Data_through_Web() throws InterruptedException, IOException {
		
		AddDataPage adp = new AddDataPage(driver);
		String specifiedHeader = "Prospectdata";
	    XLUtils excelUtil = new XLUtils();
	    excelUtil.ExcelUtil(specifiedHeader);
		
		String userName= RandomDataUtil.getName();
		String email = RandomDataUtil.getEmail(userName);
		long phoneNo = RandomDataUtil.getPhoneNo();
		String mobNo = Long.toString(phoneNo);

		adp.navigatetoData(userName, mobNo, email);
		
		adp.fillData( excelUtil.getData(1), 
	            excelUtil.getData(2),
	            excelUtil.getData(3)
	            );
		
		adp.moreData( excelUtil.getData(4), 
	            excelUtil.getData(5),
	            excelUtil.getData(6),
	            excelUtil.getData(7),
	            excelUtil.getData(8), 
	            excelUtil.getData(9)
	            );

		adp.addData( excelUtil.getData(10), 
	            excelUtil.getData(11),
	            excelUtil.getData(12),
	            excelUtil.getData(13),
	            excelUtil.getData(14), 
	            excelUtil.getData(15),
	            excelUtil.getData(16),
	            excelUtil.getData(17),
	            excelUtil.getData(18), 
				userName);

		logger.info("Data added Successfully\n");

	}

}
