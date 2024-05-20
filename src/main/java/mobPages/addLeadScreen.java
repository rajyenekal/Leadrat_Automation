package mobPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;

public class addLeadScreen extends baseScreen {

	public addLeadScreen(AppiumDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.ImageView")
	WebElement addleadBtn;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"add lead\"]")
	WebElement addLead;
	
	@FindBy(xpath="//android.widget.EditText[@text=\"ex Sachin chavan..\"]")
	WebElement leadName;
	
	@FindBy(xpath="//android.widget.EditText[@text=\"ex 9999XXXXXX\"]")
	WebElement leadNo;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"save & finish\"]")
	WebElement saveLead;
	
	public void addNewLead(String name,String number) {
		addleadBtn.click();
		addLead.isDisplayed();
		leadName.sendKeys(name);
		leadNo.sendKeys(number);
		saveLead.click();
	}
}
