package pomPages;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.ActionsUtil;
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

    @FindBy(xpath = "(//div[@col-id=\"CustomLeadStatus\"])[2]//span")
    WebElement currentStatus;

    @FindBy(xpath = "//label[@class=\"status-badge\" ]")
    WebElement subStatus;

    @FindBy(id = "bookedUnderName")
    private WebElement bookedUnderNameField;

    @FindBy(id = "projectProperty1")
    private WebElement project;

    @FindBy(id = "agreementValue")
    private WebElement agreementValueField;

    @FindBy(xpath = "//label[.='Project']/..//input")
    private WebElement projectField;

    @FindBy(xpath = "//label[.='Choose Project']/..//input")
    private WebElement chooseProjectField;

    @FindBy(xpath = "//h4[.='Booking details']")
    private WebElement projectbookingDetailsOption;

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

    @FindBy(xpath = "//label[.='Type of Payment Selected']/..//input")
    private WebElement typeofPay;

    @FindBy(id = "txtUpdateStatusNotes")
    private WebElement notesField;

    @FindBy(xpath = "//button[contains(.,'Save & Go to Next')]")
    private WebElement saveGoToNextButton;

    @FindBy(xpath = "//div[.='Invoice added successfully.']")
    private WebElement invoiceAdded;
    
    @FindBy(xpath = "//h4[.='Brokerage info']")
    private WebElement brokerageInfo;
    
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
    
    @FindBy(xpath = "//h4[contains(.,'Invoice')]")
    private WebElement invoice;
    
    @FindBy(xpath = "//button[.='Save and Close']")
    private WebElement saveClose;

	@FindBy(xpath="//div[contains(.,'Updated Successfully')]")
	private WebElement toastMsg;

    public boolean clickOption(String name) {
        WebElement popOption = ldriver.findElement(By.xpath("//div[contains(@class,'ng-option') and contains(.,'" + name + "')]"));
        waits.waitTillClickable(popOption);
        popOption.click();
        return true;
    }

    public void selectStatus(String status) {
        waits.waitTillClickable(currentStatus);
        currentStatus.click();
        WebElement sts = ldriver.findElement(By.xpath("//label[contains(@class,'status-badge') and contains(.,'" + status + "')]"));
        waits.waitTillClickable(sts);
        jse.jsClick(sts);
        waits.waitTillClickable(subStatus);
        jse.jsClick(subStatus);
    }

    public boolean fillBookingForm(String status, String bookedUnderName, String agreementValue, String projectName, String unitName, String notes, String photo,String adhar,String pan,String passport, String carParkingCharges, String addOnCharges, String tokenAmountPaid, String payMode, String discount, String discountType, String payType, String gst, String referralName, String referralNo, String referralCommission) throws AWTException, InterruptedException {
        waits.waitTillVisible(leadsHeader);
        pendingLead.click();
        selectStatus(status);
        bookedUnderNameField.sendKeys(bookedUnderName);
        agreementValueField.sendKeys(agreementValue);
        waits.waitTillClickable(project);
        project.click();
        projectField.sendKeys(projectName);
        chooseProjectField.sendKeys(projectName);
        clickOption(projectName);
        unitField.sendKeys(unitName);
        clickOption(unitName);
        statusNotesField.sendKeys(notes);
        saveFillFormButton.click();
        
        ActionsUtil.uploadFile(ldriver, photo, "photo");
        ActionsUtil.uploadFile(ldriver, adhar, "Aadhar");
        ActionsUtil.uploadFile(ldriver, pan, "PAN");
        ActionsUtil.uploadFile(ldriver, passport, "Passport");

        carParkingChargesField.sendKeys(carParkingCharges);
        addOnChargesField.sendKeys(addOnCharges);
        tokenAmountPaidField.sendKeys(tokenAmountPaid);
        paymentModeField.sendKeys(payMode);
        clickOption(payMode);
        
        checkmarkCheckbox.click();
        discountField.sendKeys(discount);
        discountTypeField.sendKeys(discountType);
        clickOption(discountType);
        typeofPay.sendKeys(payType);
        clickOption(payType);
        waits.waitTillClickable(saveGoToNextButton);
        saveGoToNextButton.click();
        
        waits.waitTillVisible(invoiceAdded);
        waits.waitTillVisible(brokerageInfo);
        brokerageInfo.isDisplayed();
        gstField.sendKeys(gst);
        referralNameField.sendKeys(referralName);
        referralNoField.sendKeys(referralNo);
        referralCommissionField.sendKeys(referralCommission);
        saveMoveToInvoiceButton.click();
        waits.waitTillVisible(invoiceAdded);
        invoiceAdded.isDisplayed();
        waits.waitTillVisible(invoice);
        invoice.isDisplayed();
        waits.waitTillClickable(currentStatus);
        currentStatus.click();
        WebElement sts = ldriver.findElement(By.xpath("//label[contains(@class,'status-badge') and contains(.,'Booking Cancel')]"));
        waits.waitTillClickable(sts);
        jse.jsClick(sts);
        WebElement substs = ldriver.findElement(By.xpath("//input[@formcontrolname=\"reason\"]/..//label[contains(@class,'status-badge' )]"));
        waits.waitTillClickable(substs);
        substs.click();
        waits.waitTillVisible(saveClose);
        saveClose.click();
        waits.waitTillVisible(toastMsg);
        return toastMsg.isDisplayed();
        
    }
}
