package Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

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

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

public class S3ExtentUtils {

    private static final String BUCKET_NAME = "test-automation-report"; 
    private static final String REGION = "eu-north-1"; 
    private static final String S3_URL = "https://test-automation-report.s3." + REGION + ".amazonaws.com/";
    static ReadConfigFile rcf = new ReadConfigFile();
    public static String accessKey = rcf.getAccessKey();
    public static String accessId = rcf.getSecreKey();

    // AWS credentials
    private static final String ACCESS_KEY_ID = accessKey; 
    private static final String SECRET_ACCESS_KEY = accessId; 

    // Upload file to S3
    public static String uploadFileToS3(String localFilePath, String keyName) {
        try {
            S3Client s3 = S3Client.builder()
                    .region(Region.of(REGION))
                    .credentialsProvider(StaticCredentialsProvider.create(
                            AwsBasicCredentials.create(ACCESS_KEY_ID, SECRET_ACCESS_KEY)))
                    .build();

            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(BUCKET_NAME)
                    .key(keyName)
                    .build();

            s3.putObject(putObjectRequest, RequestBody.fromFile(Paths.get(localFilePath)));

            System.out.println("File uploaded to S3 successfully: " + keyName);
            return S3_URL + keyName; 
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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

 // Updated method to send email with embedded S3 report link
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
                new InternetAddress("rajneesh.k@leadrat.com"),
                new InternetAddress("nowlak.s@leadrat.com"),
                new InternetAddress("jayakumar.k@leadrat.com"),
                new InternetAddress("Nitish.s@leadrat.com"),
                new InternetAddress("sudesh@leadrat.com"),
            };
            message.setRecipients(Message.RecipientType.TO, recipients);
            message.setSubject("Smoke Test " + result + " ");

            // Upload report to S3
            String localReportPath = ".\\reports\\" + reportName;
            String s3ReportKey = "test-reports/" + reportName;
            String s3ReportLink = uploadFileToS3(localReportPath, s3ReportKey);

            // Create the email body part
            BodyPart messageBodyPart = new MimeBodyPart();
            String emailContent;

            if (result.equalsIgnoreCase("Passed")) {
                // Embed the S3 link in the success message
                emailContent = successMsg.replace("{report_link}", s3ReportLink);
            } else {
                // Embed the S3 link in the failure message
                emailContent = failmsg.replace("{report_link}", s3ReportLink);
            }

            // Explicitly set the content type and charset
            messageBodyPart.setContent(emailContent, "text/html; charset=UTF-8");

            // Create the multipart message
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);

            // Set the email content
            message.setContent(multipart);

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully with S3 report link embedded.");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    static String successMsg = "Dear Team,<br><br>"
            + "I&rsquo;m excited to share that the Smoke Test for our project has been successfully completed, and all scripts have passed! &#x1F3C6;&#x2728;<br><br>"
            + "You can review the full report here: <a href='{report_link}'>Click here to view the full report</a><br><br>"
            + "If you have any questions or need further details, feel free to reach out.<br><br>"
            + "Thank you for your support and collaboration! &#x1F44D;<br><br>"
            + "Best regards,<br>"
            + "Rajaneesh K B<br>"
            + "Quality Analyst<br>"
            + "&#x1F4DE; +919741846197<br>";

    static String failmsg = "Dear Team,<br><br>"
            + "Unfortunately, our recent Smoke Test for the project encountered some issues, and not all scripts passed. &#x1F6A8;&#x1F50D;<br><br>"
            + "You can review the full report here: <a href='{report_link}'>Click here to view the full report</a><br><br>"
            + "If you have any questions or need more information, please don&rsquo;t hesitate to contact me.<br><br>"
            + "We appreciate your attention to this matter and will keep you updated on our progress. &#x1F527;<br><br>"
            + "Best regards,<br>"
            + "Rajaneesh K B<br>"
            + "Quality Analyst<br>"
            + "&#x1F4DE; +919741846197<br>";


}
