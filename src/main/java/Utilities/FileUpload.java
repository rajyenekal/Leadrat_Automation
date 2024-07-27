package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class FileUpload {

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

    public static void addImageToReport(ExtentTest test, String imageName) {
        String imagePath = "./src/test/resources/image/" + imageName;
        File imageFile = new File(imagePath);

        if (imageFile.exists()) {
            try {
                byte[] imageData = Files.readAllBytes(imageFile.toPath());
                String base64Image = Base64.getEncoder().encodeToString(imageData);
                test.log(Status.INFO, "<div align='center'><img src='data:image/jpeg;base64," + base64Image + "' width='25%' height='25%'/></div>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Image file not found: " + imagePath);
        }
    }

    public static boolean isAPITest(ITestResult result) {
        String className = result.getTestClass().getName();
        return (" " + className.toLowerCase() + " ").contains("api");
    }

    public static boolean isMobTest(ITestResult result) {
        String className = result.getTestClass().getName();
        return (" " + className.toLowerCase() + " ").contains("mob");
    }

    public static void sendEmail(String result, String reportName) {
        final String username = "digilanterndigi@gmail.com";
        final String password = "fslr iwfg hhaz clnj";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));

            // Add multiple recipients
            InternetAddress[] recipients = {
                new InternetAddress("rajyenekal@gmail.com"),
//                new InternetAddress("rajneesh.k@leadrat.com"),
//                new InternetAddress("jayakumar.k@leadrat.com"),
//                new InternetAddress("Nitish.s@leadrat.com"),
//                new InternetAddress("sudesh@leadrat.com"),
            };
            message.setRecipients(Message.RecipientType.TO, recipients);
            message.setSubject("Smoke Test "+result+" ");

            // Create the email body part
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Dear User,\r\n"
                    + "\r\n"
                    + "I'm pleased to inform you that the Smoke Test for our project has been " + result + "\r\n"
                    + "\r\n"
                    + "Please find the Execution report attached.\r\n"
                    + "\r\n"
                    + "If you have any questions or need further assistance, please don't hesitate to reach out.\r\n"
                    + "\r\n"
                    + "Best regards,\r\n"
                    + "Rajaneesh K B\r\n"
                    + "Quality Analyst-1\r\n"
                    + "+919741846197");

            // Create the multipart message
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Attach the report file
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(".\\reports\\" + reportName);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(reportName);
            multipart.addBodyPart(messageBodyPart);

            // Set the email content
            message.setContent(multipart);

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
