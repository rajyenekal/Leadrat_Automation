package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ActionsUtil {

	Actions actions ;
	
	public ActionsUtil(WebDriver driver) {
		actions = new Actions(driver);
	}
	
	public void enterDataIntoTextField(WebElement targetElement , String dataToEnter) {
		targetElement.clear();
		actions.sendKeys(targetElement,dataToEnter).perform();
	}
	
	public void mouseHoverOnElement(WebElement targetElement) {
		actions.moveToElement(targetElement).perform();
	}
	
	public void mouseHoverOnElementCoordinates(WebElement targetElement, int xOffset , int yOffset) {
		actions.moveToElement(targetElement, xOffset, yOffset).perform();
	}
	
	public void moveCursorBy(int xOffset , int yOffset) {
		actions.moveByOffset(xOffset, yOffset).perform();
	}
	
	public void clickOnElement(WebElement targetElement) {
		actions.click(targetElement).perform();
	}

	public void doubleClickOnElement(WebElement targetElement) {
		actions.doubleClick(targetElement).perform();
	} 
	
	public void rightClickOnElement(WebElement targetElement) {
		actions.contextClick(targetElement).perform();
	}
	
	public void dragAndDropAnElement(WebElement sourcetElement , WebElement destElement) {
		actions.dragAndDrop(sourcetElement, destElement).perform();
	}
	
	public void dragAndDropAnElementToCoordinate(WebElement sourcetElement , int xOffset , int yOffset) {
		actions.dragAndDropBy(sourcetElement, xOffset , yOffset).perform();
	}
	
	public Boolean isSelected(WebElement element) {
		return element.isSelected();
	}
	
	public static boolean uploadFile(WebDriver driver, String filePath, String fileType) throws AWTException, InterruptedException {

        WaitsUtil waits = new WaitsUtil(driver);
        JavaScriptUtil jse = new JavaScriptUtil(driver);
        WebElement fileElement = driver.findElement(By.xpath("//span[contains(.,'click to Upload " + fileType + "')]"));
        waits.waitTillClickable(fileElement);

        // Click the element using JavaScript if regular click fails
        try {
            fileElement.click();
        } catch (Exception e) {
            jse.jsClick(fileElement);
        }

        // Copy file path to clipboard
        StringSelection ss = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        Thread.sleep(500);

        // Ensure window focus
        driver.switchTo().defaultContent();

        // Use Robot class to paste the file path and press Enter
        Robot robot = new Robot();
        robot.setAutoDelay(1000); // Slight delay for each action

        // Press CTRL+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        // Press Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        // Wait for the document to be added and return its presence status
        WebElement addedDocument = driver.findElement(By.xpath("//span[contains(.,'click to Upload " + fileType + "')]/../../../../../../../..//a[contains(@class,'green')]/..//span[contains(@class,'delete')]"));
        waits.waitTillVisible(addedDocument); // Ensure the document is visible before checking its presence
        return addedDocument.isDisplayed();
    }

}
