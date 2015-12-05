package app;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

public class SimpleJavaMailProgram {
	
	public static void main(String args[]) {
		
		String emailAddress = "tonofal@yahoo.com";
		sendMail(emailAddress);
		
		
		
}

	
	/**
	 * Send Email to this Reciepent
	 * 
	 */
	private static void sendMail(String emailAddress) {
		
		
		 String host="smtp.gmail.com";
		  
		 
		 	Properties props = new Properties();
	        props.put("mail.smtp.starttls.enable","true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.port", "587");
	        props.put("mail.debug", "true");
	        props.put("mail.smtp.auth", "true");
	        
	        
	        Authenticator auth = new SMTPAuthenticator();
	       
	        try { 
	       
	        	InternetAddress internetAddresses = new InternetAddress("","tonofal@yahoo.com");
	        	Session session = Session.getInstance(props,auth);
	        	MimeMessage msg=new MimeMessage(session);	
	        	msg.setFrom(internetAddresses);
	        
	        	msg.setRecipient(Message.RecipientType.TO,new InternetAddress("tonofal@yahoo.com"));
	        	msg.setSubject("Your Application is in Process");
	        	
	        	MimeBodyPart message_body=new MimeBodyPart();
	        	message_body.setContent("We are processing your Bank Account Application, < br> Please give us 24 hours. Thank you <br> Bank Of Danish , CEO ",
	        			"text/plain");
	        	
	        	Transport.send(msg);
	        	
	        	System.out.println("Message sent");
	        	
	        	     
	            
	        	
	        	
	        	
	        	
	}
	
	        catch(Exception ex ) {
	        	
	        	ex.printStackTrace();
	}
        	
	       
		 
		
		
		
	}
	
	

}
