package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
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
	
	public void Login(String userName,String Pwd) {
		UserName.sendKeys(userName);
		pwd.sendKeys(Pwd);
		loginBtn.click();
		leadratLogo.isDisplayed();
	}
	
	

}
