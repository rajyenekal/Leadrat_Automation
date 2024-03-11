package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	static WebDriver ldriver;
	
	public BasePage(WebDriver driver) {
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}

	
}
