package Utilities;

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
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentUtils {

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
            message.setSubject("Smoke Test " + result + " ");

            // Create the email body part
            BodyPart messageBodyPart = new MimeBodyPart();
            
            if(result.equalsIgnoreCase("Passed 🏆")) {
                messageBodyPart.setContent(successMsg, "text/html; charset=UTF-8");
            } else {
                messageBodyPart.setContent(failmsg, "text/html; charset=UTF-8");
            }

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

    static String successMsg = "Dear Team,<br><br>"
            + "I’m excited to share that the Smoke Test for our project has been successfully completed, and all scripts have passed! 🏆✨<br><br>"
            + "Please find the execution report attached for your review. It includes detailed information on the tests performed, including metrics and screenshots where applicable.<br><br>"
            + "If you have any questions or need further details, feel free to reach out.<br><br>"
            + "Thank you for your support and collaboration! 👍<br><br>"
            + "Best regards,<br>"
            + "Rajaneesh K B<br>"
            + "Quality Analyst<br>"
            + "📞 +919741846197<br>";

    static String failmsg = "Dear Team,<br><br>"
            + "Unfortunately, our recent Smoke Test for the project encountered some issues, and not all scripts passed. 🚨🔍<br><br>"
            + "Please find the execution report attached. It provides details on the tests performed and the specific errors encountered with screenshot.<br><br>"
            + "If you have any questions or need more information, please don’t hesitate to contact me.<br><br>"
            + "We appreciate your attention to this matter and will keep you updated on our progress. 🛠️<br><br>"
            + "Best regards,<br>"
            + "Rajaneesh K B<br>"
            + "Quality Analyst<br>"
            + "📞 +919741846197<br>";
}
