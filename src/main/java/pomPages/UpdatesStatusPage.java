package pomPages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.JavaScriptUtil;
import Utilities.WaitsUtil;

public class UpdatesStatusPage extends BasePage{

	public UpdatesStatusPage(WebDriver driver) {
		super(driver);
	}
	
	WaitsUtil waits = new WaitsUtil(ldriver);
	JavaScriptUtil jse = new JavaScriptUtil(ldriver);

	@FindBy(id="clkLeadsCurrentPending")
	WebElement Pending;
	
	@FindBy(xpath="(//lead-name-section)[1]")
	WebElement leadName;
	
	@FindBy(xpath="(//div[@col-id=\"CustomLeadStatus\"])[2]//span")
	WebElement currentStatus;
	
	@FindBy(xpath="//label[@class=\"status-badge\" and contains(.,'Callback')]")
	WebElement statusName;
	
	@FindBy(xpath="//label[@class=\"status-badge\" ]")
	WebElement subStatus;
	
	@FindBy(id="inpAppDateTime")
	WebElement scheduleDate;
	
	@FindBy(xpath="//span[.=' Set ']")
	WebElement setDate;
	
	@FindBy(xpath="//button[.='Save and Close']")
	WebElement saveClose;
	
	@FindBy(xpath="//div[.='Lead Status Updated Successfully']")
	WebElement leadUpdatedMsg;
	
	@FindBy(id="txtUpdateStatusNotes")
	WebElement notes;
	
	@FindBy(id ="clkLeadsCurrentScheduled")
	WebElement scheduled;
	
	@FindBy(xpath="//h3[.='Appointment Details']")
	WebElement appointDetails;
	
	@FindBy(xpath="//textarea[@formcontrolname=\"notes\"]")
	WebElement meetingNote;

	@FindBy(xpath="//p[.='Meeting Scheduled']")
	WebElement meetingScheduled;
	
	@FindBy (xpath="//span[contains(@class,'person-walking')]")
	WebElement walkingMuso;
	
	@FindBy(id="btnUpdateLeadStatus")
	WebElement upldateLeadStatus;
	
	@FindBy(xpath="//div[.='Done']")
	WebElement done;
	
	@FindBy(id="inpExecutiveName")
	WebElement executiveName;
	
	@FindBy(xpath="//input[@id=\"mat-input-0\" and @type=\"tel\"]")
	WebElement executiveNo;
	
	@FindBy(xpath="//h5[.='Save & Close']")
	WebElement saveupdStatus;

	@FindBy(xpath="//div[contains(.,'Updated Successfully')]")
	WebElement toastMsg;
	
	@FindBy(id="deleteYes")
	WebElement yes;
	
	@FindBy(xpath="//span[.='Add Project']")
	WebElement addProject;
	
	@FindBy(xpath="//label[.='add project name']/..//input")
	WebElement projectField;
	
	@FindBy(xpath="//div[contains(@class,'option')]")
	WebElement option;
	
	@FindBy(xpath="//button[.='Add']")
	WebElement add;
	
	public void addProject() {
		
		if(addProject.isDisplayed()) {
			addProject.click();
			waits.waitTillClickable(projectField);
			projectField.click();
			waits.waitTillClickable(option);
			option.click();
			jse.jsClick(add);
			walkingMuso.isDisplayed();
		}
	}
	
	
	public WebElement getTomorrowDateElement() {
		
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
        String formattedDate = tomorrow.format(formatter);
        String dateXPath = String.format("//td[@aria-label='%s']", formattedDate);
        return ldriver.findElement(By.xpath(dateXPath));
    }

    public void selectTomorrowDate() {
        scheduleDate.click();
        WebElement dateElement = getTomorrowDateElement();
		waits.waitTillClickable(dateElement);
        dateElement.click();
		waits.waitTillClickable(setDate);
        setDate.click();
    }
	
	
    public void selectStatus(String status) {
    	WebElement sts = ldriver.findElement(By.xpath("//label[contains(@class,'status-badge') and contains(.,'"+status+"')]"));
    	waits.waitTillClickable(sts);
    	jse.jsClick(sts);
    	waits.waitTillClickable(subStatus);
    	jse.jsClick(subStatus);
    }
    
	 public void ScheduleStatus(String status,String note) throws InterruptedException {
		 waits.waitTillClickable(Pending);
		 Pending.click();
		 waits.waitTillClickable(currentStatus);
		 currentStatus.click();
		 selectStatus(status);
		 selectTomorrowDate();
		 notes.sendKeys(note);
		 waits.waitTillClickable(saveClose);
		 jse.jsClick(saveClose);
		 waits.waitTillVisible(leadUpdatedMsg);
		 leadUpdatedMsg.isDisplayed();
	 }
	
	
	 public boolean updatemeeting(String status,String execName,String exeNo,String note) throws InterruptedException {
		 scheduled.click();
		 isActive(scheduled);
		 WebElement subStatus=ldriver.findElement(By.xpath("//a[@name=\"scheduled\"]//span[contains(.,'"+status+"')]"));
		 subStatus.click();
		 isActive(subStatus);
		 WebElement statusName=ldriver.findElement(By.xpath("//p[contains(.,'"+status+"')]"));
		 waits.waitTillClickable(statusName);
		 ldriver.findElement(By.xpath("//p[contains(.,'"+status+"')]")).click();
		 waits.waitTillVisible(walkingMuso);
		 walkingMuso.isDisplayed();
		 waits.waitTillClickable(upldateLeadStatus);
		 upldateLeadStatus.click();
		 waits.waitTillVisible(appointDetails);
		 appointDetails.isDisplayed();
		 waits.waitTillClickable(done);
		 jse.jsClick(done);
		 waits.waitTillClickable(executiveName);
		 executiveName.sendKeys(execName);
		 executiveNo.sendKeys(exeNo);
		 meetingNote.sendKeys(note);
		 waits.waitTillClickable(saveupdStatus);
		 saveupdStatus.click();
		 waits.waitTillVisible(toastMsg);
		 return toastMsg.isDisplayed();
	 }
	 
	 public boolean statusUpdate(String status,String note) {
		 waits.waitTillClickable(Pending);
		 Pending.click();
		 waits.waitTillClickable(currentStatus);
		 currentStatus.click();
		 selectStatus(status);
		 notes.sendKeys(note);
		 waits.waitTillClickable(saveClose);
		 jse.jsClick(saveClose);
		 waits.waitTillVisible(leadUpdatedMsg);
		 return leadUpdatedMsg.isDisplayed();
	 }
	 
	 
	 public boolean isActive(WebElement element) {
	        String classAttribute = element.getAttribute("class");
	        return classAttribute != null && classAttribute.contains("active");
	    }
}
