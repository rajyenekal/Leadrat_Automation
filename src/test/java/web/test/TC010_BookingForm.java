package web.test;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pomPages.BookingFormPage;
import test.base.BaseTest;

public class TC010_BookingForm extends BaseTest{

	@Test
    public void testBookingForm() throws AWTException, InterruptedException {
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
        String filePath = "C:\\Users\\New User\\Downloads\\Bulding Images\\png-transparent-architectural-engineering-building-crane-building-building-monochrome-architect-thumbnail.png";
        
        BookingFormPage bfp = new BookingFormPage(driver);
        
        bfp.fillBookingForm("Book",bookedUnderName, agreementValue, projectName, unitName, notes, carParkingCharges, addOnCharges, tokenAmountPaid, payMode, discount, discountType, gst, referralName, referralNo, referralCommission, filePath);

        // Add assertions or checks as needed
        Assert.assertTrue(true);
    }
}
