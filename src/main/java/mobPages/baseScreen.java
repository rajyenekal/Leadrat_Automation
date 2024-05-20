package mobPages;

import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;

public class baseScreen {

    private AppiumDriver ldriver;
    
    public baseScreen(AppiumDriver driver) {
        this.ldriver = driver;
        PageFactory.initElements(driver, this);
    }
    
    // Getter method for ldriver (optional)
    public AppiumDriver getDriver() {
        return ldriver;
    }
}
