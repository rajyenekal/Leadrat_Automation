package pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Utilities.ActionsUtil;
import Utilities.JavaScriptUtil;
import Utilities.WaitsUtil;

public class AddDataPage extends BasePage {

	public AddDataPage(WebDriver driver) {
		super(driver);
	}

	ActionsUtil aut = new ActionsUtil(ldriver);
	WaitsUtil waits = new WaitsUtil(ldriver);
	JavaScriptUtil jse = new JavaScriptUtil(ldriver);
	
	@FindBy(xpath="//a[@class='leftnav-item' and text()='Data']")
	@CacheLookup
	WebElement datamodule;
	
	@FindBy(xpath="//h4[.='Data Management']")
	@CacheLookup
	WebElement dataMngt;
	
	@FindBy(id="btnAddNewProspects")
	@CacheLookup
	WebElement addDataBtn;
	
	@FindBy(xpath="//h4[contains(.,'Add Data')]")
	@CacheLookup
	WebElement addData;
	
	@FindBy(xpath="//input[@formcontrolname='name']")
	@CacheLookup
	WebElement dataName;
	
	@FindBy(xpath="//label[.='Phone Number']/..//input")
	@CacheLookup
	WebElement phoneNo;
	
	@FindBy(xpath="//input[@formcontrolname='email']")
	@CacheLookup
	WebElement emailId;
	
	public void navigatetoData(String name,String phoneNo2,String mail) throws InterruptedException {
//		Thread.sleep(500);
//		datamodule.isDisplayed();
//		waits.waitTillClickable(datamodule);
//		jse.jsClick(datamodule);
//		//datamodule.click();
//		//waits.waitTillVisible(addDataBtn);
//		Thread.sleep(500);
//		waits.waitTillClickable(addDataBtn);
//		//addDataBtn.isDisplayed();
//		Thread.sleep(500);
//		addDataBtn.click();
//		//jse.jsClick(addDataBtn);
		
		ldriver.navigate().to("https://demo.leadrat.com/data/add-data");
		waits.waitTillVisible(addData);
		addData.isDisplayed();
		Thread.sleep(500);
		waits.waitTillClickable(dataName);
		dataName.sendKeys(name);
		Thread.sleep(500);
		waits.waitTillClickable(phoneNo);
		phoneNo.sendKeys(phoneNo2);
		Thread.sleep(500);
		waits.waitTillClickable(emailId);
		emailId.sendKeys(mail);
		
	}
	
	@FindBy(xpath="//div[.='Source']/..//input")
	@CacheLookup
	WebElement sourceName;
	
	@FindBy(xpath="//div[.='Sub-Source']/..//input")
	@CacheLookup
	WebElement subSource;
	
	@FindBy(xpath="//div[.='Assign to']/..//input")
	@CacheLookup
	WebElement assignTo;
	
	
	public void selectOption(String option) {
		WebElement srcName = ldriver.findElement(By.xpath("//div[@role='option']//*[contains(.,'"+option+"')]"));
		waits.waitTillVisible(srcName);
		jse.jsClick(srcName);
	}
	
	public void selecttitle(String title) {
		WebElement titleName = ldriver.findElement(By.xpath("//div[@title='"+title+"']"));
		waits.waitTillVisible(titleName);
		titleName.click();
	}
	
	public void fillData(String srcName,String subsrc,String assignee) {
		sourceName.sendKeys(srcName);
		selectOption(srcName);
		subSource.sendKeys(subsrc);
		selecttitle(subsrc);
		assignTo.sendKeys(assignee);
		selectOption(assignee);

	}
	
	@FindBy(xpath="//ng-select[@formcontrolname='locationId']//input")
	@CacheLookup
	WebElement locName;
	
	@FindBy(xpath="//div[.='Lower Budget']//input")
	@CacheLookup
	WebElement lowBudget;
	
	@FindBy(xpath="//div[.='Upper Budget']//input")
	@CacheLookup
	WebElement highBudget;
	
	@FindBy(xpath="//input[@formcontrolname='carpetArea']")
	@CacheLookup
	WebElement carpetArea;
	
	@FindBy(xpath="//ng-select[@formcontrolname='carpetAreaUnitId']")
	@CacheLookup
	WebElement carpetUnit;
	
	@FindBy(xpath="//label[.='Buy']/..//input[@name='enquiredFor']")
	@CacheLookup
	WebElement enquiredFor;
	
	@FindBy(xpath="//input[@id='residential']")
	@CacheLookup
	WebElement propType;
	
	@FindBy(xpath="//input[@id='Independent House']")
	@CacheLookup
	WebElement propSubType;
	
	@FindBy(xpath="//input[@name='noOfBHK']/..//label[.='1 BHK']")
	@CacheLookup
	WebElement noOfBHK;
	
	@FindBy(xpath="//input[@id='Simplex']")
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
	

	
	public void moreData(String area,String unit,String proj,String prop,String agency,String prof) {
		carpetArea.sendKeys(area);
		carpetUnit.click();
		selectOption(unit);
		jse.jsClick(enquiredFor);
		//enquiredFor.click();
		jse.jsClick(propType);
		jse.jsClick(propSubType);
		//propSubType.click();
		waits.waitTillClickable(noOfBHK);
		noOfBHK.click();
		waits.waitTillClickable(bhkType);
		jse.jsClick(bhkType);
		//bhkType.click();
		waits.waitTillClickable(projectsList);
		projectsList.sendKeys(proj);
		selectOption(proj);
		propertiesList.sendKeys(prop);
		selectOption(prop);
		agencyName.sendKeys(agency);
		selectOption(agency);
		selectProfession.sendKeys(prof);
		selectOption(prof);
	}
	
	@FindBy(xpath="//ng-select[@formcontrolname='profession']//input")
	@CacheLookup
	WebElement selectProfession;
	
	@FindBy(xpath="//ng-dropdown-panel[@aria-label='Options list']//div[.='Business']")
	@CacheLookup
	WebElement professionType;
	
	@FindBy(xpath="//input[@formcontrolname='companyName']")
	@CacheLookup
	WebElement companyName;

	@FindBy(xpath="//input[@formcontrolname='designation']")
	@CacheLookup
	WebElement designation;
	
	@FindBy(xpath="//input[@formcontrolname='possessionDate']")
	@CacheLookup
	WebElement possessionDate;
	
	
	
	@FindBy(xpath="//div//span[contains(@class,'calendar-cell-today')]")
	@CacheLookup
	WebElement todayDate;
	
	@FindBy(xpath="//span[contains(@class,'calendar-cell-today')]")
	@CacheLookup
	WebElement todayDate2;

	@FindBy(xpath="//ng-select[@formcontrolname='sourcingManager']//input")
	@CacheLookup
	WebElement sourcingManager;
	
	@FindBy(xpath="//ng-select[@formcontrolname='closingManager']//input")
	@CacheLookup
	WebElement closingManager;

	@FindBy(xpath="//ng-select[@formcontrolname='channelPartnerList']//input")
	@CacheLookup
	WebElement channelPartnerList;
	
	@FindBy(xpath="//input[@formcontrolname='channelPartnerExecutiveName']")
	@CacheLookup
	WebElement executiveName;
	
	@FindBy(xpath="//label[.='Executive Phone No']/..//input")
	@CacheLookup
	WebElement executiveNO;
	
	@FindBy(xpath="//ng-select[@formcontrolname='customerLocationId']//input")
	@CacheLookup
	WebElement custLocation;
	
	@FindBy(xpath="//textarea[@formcontrolname='notes']")
	@CacheLookup
	WebElement notes;
	
	@FindBy(xpath="//button[.='Save']")
	@CacheLookup
	WebElement saveBtn;
	
	
	
	public void addData(String coName,String role,String src,String cls,String channel,String executive,String execNo,String custLoc,String note,String DataName) throws InterruptedException {
		companyName.sendKeys(coName);
		designation.sendKeys(role);
		possessionDate.click();
		//waits.waitTillClickable(todayDate);
		Thread.sleep(500);
		//stl.handleStaleElement(todayDate2);
		jse.jsClick(todayDate);
		
		//todayDate.click();
		sourcingManager.sendKeys(src);
		selectOption(src);
		closingManager.sendKeys(cls);
		selectOption(cls);
		channelPartnerList.sendKeys(channel);
		selectOption(channel);
		executiveName.sendKeys(executive);
		executiveNO.sendKeys(execNo);
		custLocation.sendKeys(custLoc);
		custLocation.sendKeys(Keys.ENTER);
		selectOption(custLoc);
		notes.sendKeys(note);
		
		jse.jsClick(saveBtn);
		WebElement dataName =ldriver.findElement(By.xpath("//div[@role=\"presentation\"]//span[contains(.,'"+DataName+"')]"));
		waits.waitTillVisible(dataName);
		dataName.isDisplayed();

	}
	
	
}
