package web.test;

import java.awt.AWTException;
import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import pomPages.BookingFormPage;
import test.base.BaseTest;
import test.base.RetryAnalyzer;

public class TC010_BookingForm extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void Updating_leadStatus_as_Booked_by_filling_BookingForm_and_cancelling_Booking() throws AWTException, InterruptedException {
        // Test data
        String bookedUnderName = "Rajaneesh";
        String agreementValue = "5400000";
        String projectName = "project1";
        String unitName = "unit 1";
        String notes = "Test Book lead";
        String carParkingCharges = "100000";
        String addOnCharges = "855000";
        String tokenAmountPaid = "790700";
        String payMode = "Cash";
        String discount = "7";
        String discountType = "Direct adjustment";
        String gst = "10";
        String referralName = "Madesh";
        String referralNo = "8765432138";
        String referralCommission = "5";
        
        String photo = new File("./src/test/resources/image/photo.jpg").getAbsolutePath();
        String adhar = new File("./src/test/resources/image/adhar.png").getAbsolutePath();
        String pan = new File("./src/test/resources/image/PAN.jpg").getAbsolutePath();
        String passport = new File("./src/test/resources/image/passport.jpeg").getAbsolutePath();


        // Initialize the BookingFormPage
        BookingFormPage bfp = new BookingFormPage(driver);
        
        // Fill the booking form
        boolean isStatusUpdated =  bfp.fillBookingForm("Book", bookedUnderName, agreementValue, projectName, unitName, notes, photo,adhar,pan,passport,carParkingCharges, addOnCharges, tokenAmountPaid, payMode, discount, discountType, "Cash", gst, referralName, referralNo, referralCommission);
	        
	        Assert.assertTrue(isStatusUpdated, "Status should be updated successfully");
	        
	        if (isStatusUpdated) {
	            logger.info("Status updated successfully\n");
	        } else {
	            logger.info("Unable to update Status\n");
	        }
	    }
    
}
