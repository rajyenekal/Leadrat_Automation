/**
 * 
 */
package pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Utilities.ActionsUtil;
import Utilities.JavaScriptUtil;
import Utilities.WaitsUtil;

/**
 * 
 */
public class AddLeadPage extends BasePage{
	
	ActionsUtil aut = new ActionsUtil(ldriver);
	WaitsUtil waits = new WaitsUtil(ldriver);
	JavaScriptUtil jse = new JavaScriptUtil(ldriver);
	
	public AddLeadPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="btnAddNewLead")
	@CacheLookup
	WebElement addLeadBtn;
	
	
	@FindBy(xpath="//h4[.='Add Lead']")
	@CacheLookup
	WebElement addLead;
	
	@FindBy(id="inpLeadName")
	@CacheLookup
	WebElement leadName;
	
	@FindBy(id="mat-input-0")
	@CacheLookup
	WebElement phoneNo;
	
	@FindBy(id="inpLeadMail")
	@CacheLookup
	WebElement emailId;
	
	@FindBy(xpath="//label[.='Assign to']/..//input")
	@CacheLookup
	WebElement assignedTo;
	
	@FindBy(xpath="//label[.='Assign to']/..//input")
	@CacheLookup
	WebElement assignedTo1;
	
	@FindBy(xpath="//div[@role=\"option\"]")
	@CacheLookup
	WebElement popOption;
	
	@FindBy(xpath="//div[contains(@class,'ic-search')]/..//input")
	@CacheLookup
	WebElement location;
	
	@FindBy(xpath="//input[@type=\"checkbox\"]/..")
	@CacheLookup
	WebElement popOption1;
	
	@FindBy(id="inpLeadLowerBudget")
	@CacheLookup
	WebElement lowBudget;
	
	@FindBy(id="inpLeadUpperBudget")
	@CacheLookup
	WebElement highBudget;
	
	@FindBy(xpath="//input[@formcontrolname='carpetArea']")
	@CacheLookup
	WebElement carpetArea;
	
	@FindBy(xpath="//div[.='ex. sq. feet.']//input[@type='text']")
	@CacheLookup
	WebElement areaMeasure;
	
	@FindBy(xpath="//div[contains(@class,'ng-option')]//span[.='Sq. Feet']")
	@CacheLookup
	WebElement squareFt;
	
	@FindBy(xpath="//label[@for='Buy']")
	@CacheLookup
	WebElement enquiry;
	
	@FindBy(xpath="//label[@for='Buy']")
	@CacheLookup
	WebElement enquiry1;
	
	@FindBy(xpath="//label[@for='residential']")
	@CacheLookup
	WebElement propType;

	@FindBy(xpath="//label[@for='residential']")
	@CacheLookup
	WebElement propType1;

	@FindBy(xpath="//ng-select[@formcontrolname='propSubType']//input")
	@CacheLookup 
	WebElement propSubType;
	
	public void clickOption(String data) {
		WebElement optionData = ldriver.findElement(By.xpath("//div[@role='option' and  contains(.,'"+data+"')]"));
		waits.waitTillVisible(optionData);
		optionData.click();
	}
	
	@FindBy(xpath="//label[@for='4']")
	@CacheLookup
	WebElement bhkCount;
	
	@FindBy(xpath="//label[@for='Duplex']")
	@CacheLookup
	WebElement bhkType;
	
	@FindBy(xpath="//ng-select[@name='projectsList']//input")
	@CacheLookup
	WebElement projectsList;
	
	@FindBy(xpath="//ng-select[@name='propertiesList']//input")
	@CacheLookup
	WebElement propertiesList;
	
	@FindBy(xpath="//ng-select[@formcontrolname='agencies']//input")
	@CacheLookup
	WebElement agencyName;
	
	@FindBy(xpath="//ng-select[@placeholder='Select Profession']//input")
	@CacheLookup
	WebElement selectProfession;
	
	@FindBy(xpath="//div[@role='option' and  contains(.,'Business')]")
	@CacheLookup
	WebElement professionType;
	
	@FindBy(id="inpLeadCompanyName")
	@CacheLookup
	WebElement companyName;
	
	@FindBy(xpath="//input[@formcontrolname='designation']")
	@CacheLookup
	WebElement designation;
	
	@FindBy(xpath="//input[@id='inpPossession']/..//span[contains(@class,'ic-calendar')]")
	@CacheLookup
	WebElement calender;
	
	@FindBy(xpath="//span[contains(@class,'today')]")
	@CacheLookup
	WebElement todayDate;
	
	@FindBy(id="txtLeadNotes")
	@CacheLookup
	WebElement leadNote;
	
	@FindBy(xpath="//button[contains(@class,'btn') and .='Save']")
	@CacheLookup
	WebElement saveLead;
	
	@FindBy(xpath="//div[.='Lead added Successfully']")
	@CacheLookup
	WebElement leadAddedMsg;
	
	@FindBy(xpath="//*[.='Project(s)']")
	@CacheLookup
	WebElement projectTxt;
	
	@FindBy(xpath="//*[.='Property(s)']")
	@CacheLookup
	WebElement propertyTxt;
	
	@FindBy(xpath="//div[contains(@class,'checkbox-container')]")
	@CacheLookup
	WebElement propOpt;
	
	
	public void clickaddLeadBtn() {
		waits.waitTillClickable(addLeadBtn);
		jse.jsClick(addLeadBtn);
		addLead.isDisplayed();
	}
	
	public void enterData(String userName,Long number ,String email) {
		leadName.sendKeys(userName);
		phoneNo.sendKeys(number.toString());
		emailId.sendKeys(email);
	}
	
	public void otherdata(String assignee,String loc,String lowBdjt,String highBdjt) {
		waits.waitTillClickable(assignedTo);
		jse.jsClick(assignedTo);
		assignedTo1.sendKeys(assignee);
		waits.waitTillVisible(popOption);
		popOption.click();
		location.sendKeys(loc);
		waits.waitTillVisible(popOption1);
		popOption1.click();
		waits.waitTillClickable(lowBudget);
		lowBudget.sendKeys(lowBdjt);
		waits.waitTillClickable(highBudget);
		highBudget.sendKeys(highBdjt);
	}
	
	public Boolean anotherData(String area) {
		waits.waitTillClickable(carpetArea);
		carpetArea.sendKeys(area);
		waits.waitTillClickable(areaMeasure);
		areaMeasure.click();
		waits.waitTillClickable(squareFt);
		squareFt.click();
		waits.waitTillClickable(enquiry);
		enquiry.click();
		return enquiry1.isSelected();
	}
	
	public Boolean propType() {
		waits.waitTillClickable(propType);
		propType.click();
		return propType1.isSelected();
	}
	
	public void moreData(String subType,String project,String property, String agency, String profession,
			String company,String role,String note ) {
		
		propSubType.sendKeys(subType);
		clickOption(subType);
		bhkCount.click();
		aut.isSelected(bhkCount);
		bhkType.click();
		aut.isSelected(bhkType);
		waits.waitTillClickable(projectsList);
		projectsList.sendKeys(project);
		clickOption(project);
		projectTxt.click();
		propertiesList.sendKeys(property);
		clickOption(property);
		projectTxt.click();
		agencyName.sendKeys(agency);
		clickOption(agency);
		selectProfession.sendKeys(profession);
		clickOption(profession);
		companyName.sendKeys(company);
		designation.sendKeys(role);
		calender.click();
		waits.waitTillClickable(todayDate);
		todayDate.click();
		leadNote.sendKeys(note);
	}
	
	public Boolean saveLead(String Name) {
		waits.waitTillClickable(saveLead);
		jse.jsClick(saveLead);
		waits.waitTillVisible(leadAddedMsg);
		WebElement leadName=ldriver.findElement(By.xpath("//div[@title='"+Name+"']"));
		return leadName.isDisplayed();
		
	}
	
}
