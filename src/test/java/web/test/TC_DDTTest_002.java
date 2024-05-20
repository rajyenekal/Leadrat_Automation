package web.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.XLUtils;
import pomPages.LoginPage;
import test.base.BaseTest;

public class TC_DDTTest_002 extends BaseTest{
	
	@Test(dataProvider = "LoginData")
	public void LoginDDt(String userName,String pwd) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		
		if(lp.Login(userName, pwd)) {
			logger.info("Logged in Successfully");
		}

		else {
			Assert.assertTrue(false);
			logger.info("Failed to Log in");
		}
		
		lp.logOut();
		logger.info("Logged out Successfully");
		
		
	}

	
	@DataProvider(name="LoginData")
	
	String[][] getData() throws IOException {
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\leadRat_Logindata.xlsx";
		
		int rownum=XLUtils.getrowCount(path, "Sheet1");
		int colcount=XLUtils.getcellcount(path, "Sheet1", rownum);
		
		String loginData [][]=new String [rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}
}
