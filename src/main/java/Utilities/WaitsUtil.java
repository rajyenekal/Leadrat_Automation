package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsUtil {
	WebDriverWait wait;

	public WaitsUtil(WebDriver driver) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		 
	}
	
	public void waitTillVisible(WebElement elem) {
		wait.until(ExpectedConditions.visibilityOf(elem));
	}
	
	public void waitTillClickable(WebElement elem) {
		wait.until(ExpectedConditions.elementToBeClickable(elem));

	}

	public void waitTillInvisible(WebElement elem) {
		wait.until(ExpectedConditions.invisibilityOf(elem));
	}

	
}
