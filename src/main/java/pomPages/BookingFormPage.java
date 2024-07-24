package pomPages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.FileUpload;
import Utilities.JavaScriptUtil;
import Utilities.WaitsUtil;

public class BookingFormPage extends BasePage {
	
    public BookingFormPage(WebDriver driver) {
		super(driver);
	}

	WaitsUtil waits = new WaitsUtil(ldriver);
	JavaScriptUtil jse = new JavaScriptUtil(ldriver);


    @FindBy(id = "clkLeadsCurrentPending")
    private WebElement pendingLead;

    @FindBy(xpath = "//h4[contains(.,'Leads')]")
    private WebElement leadsHeader;

    @FindBy(xpath="//label[@class=\"status-badge\" ]")
	WebElement subStatus;
    
    @FindBy(id = "bookedUnderName")
    private WebElement bookedUnderNameField;

    @FindBy(id = "agreementValue")
    private WebElement agreementValueField;

    @FindBy(xpath = "//label[.='Project']/..//input")
    private WebElement projectField;

    @FindBy(xpath = "//label[.='Choose Project']/..//input")
    private WebElement chooseProjectField;

    @FindBy(xpath = "//div[contains(@class,'ng-option') and contains(.,'projectName')]")
    private WebElement projectOption;

    @FindBy(xpath = "//label[.='Choose Unit']/..//input")
    private WebElement unitField;

    @FindBy(xpath = "//div[contains(@class,'ng-option') and contains(.,'unitName')]")
    private WebElement unitOption;

    @FindBy(id = "txtUpdateStatusNotes")
    private WebElement statusNotesField;

    @FindBy(xpath = "//button[.='Save & fill booking form']")
    private WebElement saveFillFormButton;

    @FindBy(id = "carParkingCharges")
    private WebElement carParkingChargesField;

    @FindBy(id = "addOnCharges")
    private WebElement addOnChargesField;

    @FindBy(id = "totalSoldPrice")
    private WebElement totalSoldPriceField;

    @FindBy(id = "tokenAmountPaid")
    private WebElement tokenAmountPaidField;

    @FindBy(xpath = "//label[.='Payment Mode']/..//input")
    private WebElement paymentModeField;

    @FindBy(xpath = "//div[contains(@class,'ng-option') and contains(.,'PayMode')]")
    private WebElement paymentModeOption;

    @FindBy(id = "balanceAmount")
    private WebElement balanceAmountField;

    @FindBy(xpath = "//span[@class=\"checkmark\"]")
    private WebElement checkmarkCheckbox;

    @FindBy(id = "discount")
    private WebElement discountField;

    @FindBy(xpath = "(//span[.='Discount']/../..//input[@type=\"text\"])[2]")
    private WebElement discountTypeField;

    @FindBy(xpath = "//div[contains(@class,'ng-option') and contains(.,'discountType')]")
    private WebElement discountTypeOption;

    @FindBy(id = "txtUpdateStatusNotes")
    private WebElement notesField;

    @FindBy(xpath = "//button[contains(.,'Save & Go to Next')]")
    private WebElement saveGoToNextButton;

    @FindBy(xpath = "//label[.='GST']/..//input")
    private WebElement gstField;

    @FindBy(id = "referralname")
    private WebElement referralNameField;

    @FindBy(id = "mat-input-0")
    private WebElement referralNoField;

    @FindBy(id = "referralcommission")
    private WebElement referralCommissionField;

    @FindBy(xpath = "//button[.='Save & move to invoice']")
    private WebElement saveMoveToInvoiceButton;

    public void selectStatus(String status) {
    	WebElement sts = ldriver.findElement(By.xpath("//label[contains(@class,'status-badge') and contains(.,'"+status+"')]"));
    	waits.waitTillClickable(sts);
    	jse.jsClick(sts);
    	waits.waitTillClickable(subStatus);
    	jse.jsClick(subStatus);
    }

    public void fillBookingForm(String status,String bookedUnderName, String agreementValue, String projectName, String unitName, String notes,String filePath, String carParkingCharges, String addOnCharges, String tokenAmountPaid, String payMode, String discount, String discountType, String gst, String referralName, String referralNo, String referralCommission) throws AWTException, InterruptedException {
    	waits.waitTillVisible(leadsHeader);
        pendingLead.click();
        selectStatus(status);
        // Fill in the booking form
        bookedUnderNameField.sendKeys(bookedUnderName);
        agreementValueField.sendKeys(agreementValue);
        projectField.sendKeys(projectName);
        chooseProjectField.sendKeys(projectName);
        projectOption.click();
        unitField.sendKeys(unitName);
        unitOption.click();
        statusNotesField.sendKeys(notes);
        saveFillFormButton.click();
        // Continue with the other fields and steps similar to the above
        
        // Example: Upload files
        FileUpload.uploadFile(ldriver, filePath, "photo");
        FileUpload.uploadFile(ldriver, filePath, "Aadhar");
        FileUpload.uploadFile(ldriver, filePath, "PAN");
        FileUpload.uploadFile(ldriver, filePath, "Passport");

        // Example: Additional fields
        carParkingChargesField.sendKeys(carParkingCharges);
        addOnChargesField.sendKeys(addOnCharges);
        tokenAmountPaidField.sendKeys(tokenAmountPaid);
        paymentModeField.sendKeys(payMode);
        paymentModeOption.click();
        balanceAmountField.sendKeys(/* Calculate as needed */);
        checkmarkCheckbox.click();
        discountField.sendKeys(discount);
        discountTypeField.sendKeys(discountType);
        discountTypeOption.click();
        gstField.sendKeys(gst);
        referralNameField.sendKeys(referralName);
        referralNoField.sendKeys(referralNo);
        referralCommissionField.sendKeys(referralCommission);
        saveMoveToInvoiceButton.click();
    }
}
