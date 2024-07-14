package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import Utilities.JavaScriptUtil;
import Utilities.WaitsUtil;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	WaitsUtil waits = new WaitsUtil(ldriver);
	JavaScriptUtil jse = new JavaScriptUtil(ldriver);

	@FindBy(xpath="//img[@alt='leadrat']")
	@CacheLookup
	WebElement leadratImg;

	
	@FindBy(id="inpLoginName")
	@CacheLookup
	WebElement UserName;
	
	@FindBy(id="inpLoginPassword")
	@CacheLookup
	WebElement pwd;
	
	@FindBy(xpath="//h4[contains(@class,'btn') and .='Login']")
	@CacheLookup
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@alt=\"leadrat logo\"]/..")
	@CacheLookup
	WebElement leadratLogo;
	
	@FindBy(xpath="//div//img[@alt='profile pic']")
	@CacheLookup
	WebElement profilePic;
	
	@FindBy(xpath="//span[contains(@class,'logout')]")
	@CacheLookup
	WebElement logOut;
	
	@FindBy(xpath="//div//img[contains(@src,'loader-rat')]")
	@CacheLookup
	WebElement ratLoader;
	
	@FindBy(xpath="//div[contains(@class,'hamburger')]")
	@CacheLookup
	WebElement hamburger;
	
	
	
	public Boolean Login(String userName,String Pwd) {
		leadratImg.isDisplayed();
		UserName.sendKeys(userName);
		pwd.sendKeys(Pwd);
		loginBtn.click();
		
		if(hamburger.isDisplayed()) {
			jse.jsClick(hamburger);
		}
		return leadratLogo.isDisplayed();
	}
	
	public void logOut() {
		//waits.waitTillInvisible(ratLoader);
		waits.waitTillClickable(profilePic);
		//jse.jsClick(profilePic);
		profilePic.click();
		waits.waitTillClickable(logOut);
		//jse.jsClick(logOut);
		logOut.click();
		//waits.waitTillVisible(leadratImg);
		//return leadratImg.isDisplayed();
	}
}
