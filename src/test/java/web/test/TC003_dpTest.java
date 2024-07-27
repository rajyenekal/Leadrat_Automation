package web.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.XLUtils;
import pomPages.LoginPage;
import test.base.LaunchTest;
import test.base.RetryAnalyzer;

public class TC003_dpTest extends LaunchTest {

    @Test(dataProvider = "LoginData", retryAnalyzer = RetryAnalyzer.class)
    public void Logging_in_with_multiple_credentials(String userName, String pwd) throws InterruptedException {
        LoginPage lp = new LoginPage(driver);

        try {
            if (lp.Login(userName, pwd)) {
                logger.info("Logged as "+userName+"in Successfully\n");
            } else {
                Assert.fail("Failed to Log in for user: " + userName);
            }
        } catch (Exception e) {
            logger.error("Exception occurred during login: " + e.getMessage());
            Assert.fail("Failed to Log in for user: " + userName);
        } finally {
            lp.logOut();
            logger.info("Logged out Successfully\n");
        }
    }

    @DataProvider(name = "LoginData")
    public Object[][] getData() throws IOException {
        String path = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\leadRat_testdata.xlsx";

        int rowCount = XLUtils.getRowCount(path, "Sheet1");
       // int colCount = XLUtils.getCellCount(path, "Sheet1", 1); // Assuming column count is consistent

        // Only fetch the first two columns for username and password
        Object[][] loginData = new Object[rowCount][2];

        int validDataCount = 0;
        for (int i = 1; i <= rowCount; i++) {
            String userName = XLUtils.getCellData(path, "Sheet1", i, 0); // Username column
            String pwd = XLUtils.getCellData(path, "Sheet1", i, 1); // Password column

            if (userName != null && !userName.trim().isEmpty() && pwd != null && !pwd.trim().isEmpty()) {
                loginData[validDataCount][0] = userName;
                loginData[validDataCount][1] = pwd;
                validDataCount++;
            } 
        }

        // Adjust the array size to the number of valid data rows
        Object[][] validLoginData = new Object[validDataCount][2];
        System.arraycopy(loginData, 0, validLoginData, 0, validDataCount);

        logger.info("Total valid login data count: " + validDataCount);
        return validLoginData;
    }
}
