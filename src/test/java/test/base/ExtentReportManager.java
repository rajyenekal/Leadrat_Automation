package test.base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
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

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    public String repName;
    public String timeStamp;
    public WebDriver driver;

    public void onStart(ITestContext testContext) {
        timeStamp = new SimpleDateFormat("hh.mm.ss a.dd.MM.yyyy").format(new Date());
        repName = "Test-Report-" + timeStamp + ".html";

        sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);
        sparkReporter.config().setDocumentTitle("LeadRat Automation Project");
        sparkReporter.config().setReportName("LeadRat Automation Test Report");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Application", "Leadrat Real Estate");
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", "Rajaneesh");
    }

    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.createNode(result.getName());
        test.log(Status.PASS, "Test Passed");

        // Add image if any
        addImageToReport(test, "leadrat_logo.jpg");
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.createNode(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, "Test Failed");
        test.log(Status.FAIL, result.getThrowable().getMessage());

        // Log if the test is being retried
        if (result.getAttribute("retryAnalyzer") != null) {
            RetryAnalyzer retryAnalyzer = (RetryAnalyzer) result.getAttribute("retryAnalyzer");
            if (retryAnalyzer.retry(result)) {
                test.log(Status.WARNING, "Retrying the failed test...");
            }
        }

        // Check if the test is an API test
        if (!isAPITest(result)) {
            // Capture and embed screenshot if not an API test
            try {
                String screenshotPath;
                if (isMobTest(result)) {
                    screenshotPath = MobBase.captureScreenshot(result.getName());
                } else {
                    screenshotPath = BaseTest.captureScreenshot(result.getName());
                }

                File screenshotFile = new File(screenshotPath);
                if (screenshotFile.exists()) {
                    String base64Screenshot = Base64.getEncoder().encodeToString(Files.readAllBytes(screenshotFile.toPath()));
                    test.addScreenCaptureFromBase64String(base64Screenshot);
                } else {
                    System.out.println("Screenshot file not found: " + screenshotPath);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Add image if any
        addImageToReport(test, "leadrat_logo.jpg");
    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.createNode(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, "Test Skipped");
        test.log(Status.SKIP, result.getThrowable().getMessage());

        // Add image if any
        addImageToReport(test, "leadrat_logo.jpg");
    }

    public void onFinish(ITestContext testContext) {
        extent.flush();

        boolean hasFailedTests = testContext.getFailedTests().size() > 0;
        if (!hasFailedTests) {
            sendEmail("Passed!");
        } else {
            sendEmail("Failed!");
        }
    }

    private boolean isAPITest(ITestResult result) {
        String className = result.getTestClass().getName();
        return (" " + className.toLowerCase() + " ").contains("api");
    }

    private boolean isMobTest(ITestResult result) {
        String className = result.getTestClass().getName();
        return (" " + className.toLowerCase() + " ").contains("mob");
    }

    private void sendEmail(String result) {
    	
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
//                    new InternetAddress("rajneesh.k@leadrat.com"),
//                    new InternetAddress("jayakumar.k@leadrat.com")


            };
            message.setRecipients(Message.RecipientType.TO, recipients);
            message.setSubject("Suite Execution Report");

            // Create the email body part
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Dear User,\r\n"
                    + "\r\n"
                    + "I'm pleased to inform you that the Suite Execution for our project has been " + result + "\r\n"
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
            DataSource source = new FileDataSource(".\\reports\\" + repName);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(repName);
            multipart.addBodyPart(messageBodyPart);

            // Set the email content
            message.setContent(multipart);

            // Send the email
            Transport.send(message);

            System.out.println("Email sent Successfully.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private void addImageToReport(ExtentTest test, String imageName) {
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
}
