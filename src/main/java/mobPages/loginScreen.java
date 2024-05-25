package mobPages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class loginScreen extends baseScreen {

    public loginScreen(AppiumDriver driver) {
        super(driver);
    }
    
    
    
    @FindBy(xpath="//android.widget.EditText[@text=\"Enter domain name\"]")
    WebElement domainName;
    
    @FindBy(xpath="(//android.widget.ImageView)[3]")
    WebElement connect;
    
    @FindBy(xpath="//android.widget.EditText[@text=\"username\"]")
    WebElement userName;
    
    @FindBy(xpath="//android.widget.EditText[@text=\"password\"]")
    WebElement password;
    
    @FindBy(xpath="//android.widget.RelativeLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.ImageView")
    WebElement loginBtn;  
    
    @FindBy(xpath="//android.widget.TextView[@text=\"manage leads\"]")
    WebElement manageLeads;
    
    public void login(String domain, String un, String pwd) {
    
    	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
    
        domainName.sendKeys(domain);
        connect.click();
        userName.sendKeys(un);
        password.sendKeys(pwd);
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
        manageLeads.isDisplayed();
    }
}
