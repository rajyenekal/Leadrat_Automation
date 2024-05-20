package Utilities;
import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StaleElementHandler {

    private WebDriver driver;
    public StaleElementHandler(WebDriver driver) {
        this.driver = driver;
        new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Method to handle stale element using a retry mechanism
    public WebElement handleStaleElement(WebElement element) {
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10)) // Adjust the timeout as needed
                .pollingEvery(Duration.ofMillis(500)) // Adjust the polling interval as needed
                .ignoring(StaleElementReferenceException.class);

        return fluentWait.until(driver -> {
            try {
                // Check if the element is still attached to the DOM
                element.isDisplayed();
                return element;
            } catch (StaleElementReferenceException e) {
                // Element is stale, waiting for a short period before retrying
                return null;
            }
        });
    }

    
}
