import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailSender {
	
	public static void main(String[] s){
	
		final String userName = "sender's email address “;//sender’s mail address
		final String password = “**************”; //sender's password
		final String sendTo = "btwseeu78@gmail.com"; //reciever's address
		
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, password);
			}
		});
		
		Message messgae = new MimeMessage(session);

		try{
			messgae.setSubject("Congrats");//Subject
			messgae.setFrom(new InternetAddress(userName));
			messgae.setRecipient(RecipientType.TO, new InternetAddress(sendTo));
			messgae.setText("HIIII write your message here!!!”);//Body of the message
			Transport.send(messgae);
			System.out.println("Successfully sent to " + sendTo + " .");
		}catch(Exception exp){
			System.out.println("Couldn't send the mail due to " + exp.getMessage());
		}
		
	}
	
}