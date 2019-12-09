

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;

public class Emailer
{
	private static String sender = "sjsuflighttracker@gmail.com";
	private static String recipient;
	private static String origin;
	private static String destination;
	private static String date; // needs to be YYYY-MM-DD format
	private static String targetPrice;
	private static String currPrice;

	private static String body;
	private static String subject;

	public Emailer(String recipient) {
		this.recipient = recipient;
	}
	/**
	 *
	 * @param recipient
	 * @param origin
	 * @param destination
	 * @param targetPrice
	 * @param currPrice
	 */
	public Emailer(String recipient,String origin,String destination,String date, String targetPrice, String currPrice) {
		this.recipient = recipient;
		this.origin = origin;
		this.destination = destination;
		this.date = date;
		this.targetPrice = targetPrice;
		this.currPrice = currPrice;
	}

	public void sendMail(String subject, String body) {

		this.subject = subject;
		this.body = body;

	      // Setting up mail server
	      Properties properties = new Properties();
	      properties.put("mail.transport.protocol", "smtp");
	      properties.put("mail.smtp.host", "smtp.gmail.com");
	      properties.put("mail.smtp.port", "587");

	      //Issue STARTTLS command
	      properties.put("mail.smtp.starttls.enable", "true");

	      //Authentication for host email
	      properties.put("mail.smtp.auth", "true");

	      Authenticator authenticator = new Authenticator() {
	          protected PasswordAuthentication getPasswordAuthentication() {
	              return new PasswordAuthentication("sjsuflighttracker@gmail.com", "memes1337");
	          }
	      };

	      // creating session object to get properties
	      Session session = Session.getDefaultInstance(properties, authenticator);

	      try
	      {

	         // MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From Field: adding senders email to from field.
	         message.setFrom(new InternetAddress(sender));

	         // Set To Field: adding recipient's email to from field.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

	         // Set Subject: subject of the email
	         message.setSubject(subject);

	         // set body of the email.
	         message.setText(body);

	         // Send email.
	         Transport.send(message);
	         System.out.println("Mail successfully sent :)");
	      }
	      catch (MessagingException mex)
	      {
	         mex.printStackTrace();
	      }
	}


	//@Overload
	public void sendMail() {
		body = "Flight " + origin + " to " + destination + ", on " + date + " has fallen below " + targetPrice
				+ " and is now " + currPrice + ". Prices are subject to change quickly, so book now!";

		subject = "Flight Tracker Update";

	      // Setting up mail server
	      Properties properties = new Properties();
	      properties.put("mail.transport.protocol", "smtp");
	      properties.put("mail.smtp.host", "smtp.gmail.com");
	      properties.put("mail.smtp.port", "587");

	      //Issue STARTTLS command
	      properties.put("mail.smtp.starttls.enable", "true");

	      //Authentication for host email
	      properties.put("mail.smtp.auth", "true");

	      Authenticator authenticator = new Authenticator() {
	          protected PasswordAuthentication getPasswordAuthentication() {
	              return new PasswordAuthentication("sjsuflighttracker@gmail.com", "memes1337");
	          }
	      };

	      // creating session object to get properties
	      Session session = Session.getDefaultInstance(properties, authenticator);

	      try
	      {
	         // MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From Field: adding senders email to from field.
	         message.setFrom(new InternetAddress(sender));

	         // Set To Field: adding recipient's email to from field.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));

	         // Set Subject: subject of the email
	         message.setSubject(subject);

	         // set body of the email.
	         message.setText(body);

	         // Send email.
	         Transport.send(message);
	         System.out.println("Mail successfully sent :)");
	      }
	      catch (MessagingException mex)
	      {
	         mex.printStackTrace();
	      }
	}

   public static void main(String [] args)
   {
	   Emailer emailer = new Emailer("natpanzarini@gmail.com","SFO","SJC","420","400");

	   emailer.sendMail();


   }
}
