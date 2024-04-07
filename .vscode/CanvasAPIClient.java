import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.mail.*;
import javax.mail.internet.*;

public class CanvasAPIClient {
    private static final String CANVAS_API_URL = "https://your-canvas-instance/api/v1/";
    private static final String API_KEY = "19304~9IQ18ukLl8JQl5oXCXe5mzl7VAUEK4FFgjBZbSUdY2LLb2YPFf9yCA1ZfxhnXeUn";
    private static final String EMAIL_USERNAME =  "kcrst23@gmail.com";
    private static final String EMAIL_PASSWORD = "LHS2025@kc12";
    private static final String EMAIL_RECIPIENT = "kaylach27@icloud.com";

    public static void main(String[] args) {
        try {
            // Connect to Canvas API
            URL url = new URL(CANVAS_API_URL + "courses");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Send email
            String emailSubject = "Canvas API Connection Test";
            String emailContent = "Successfully connected to Canvas API.";
            sendEmail(emailSubject, emailContent);

            // Print Canvas API response
            System.out.println(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendEmail(String subject, String content) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.example.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_USERNAME, EMAIL_PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(EMAIL_RECIPIENT));
            message.setSubject(subject);
            message.setText(content);
            Transport.send(message);
            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
