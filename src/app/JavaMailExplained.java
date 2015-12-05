package app;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class JavaMailExplained {
	
	
	
	
	
	public static void sendMail(String email, String feedBackMessage,
			String phone) {
		//String to="adm.kiaconsulting@gmail.com";
		String to="junaid.jp@gmail.com" ;
		//String from = email;
	        // SUBSTITUTE YOUR ISP'S MAIL SERVER HERE!!!
	        //String host = "smtp.jdnenterprises.com";
	        String host="smtp.gmail.com";
	        //java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	        // Create properties, get Session
	        Properties props = new Properties();
	        props.put("mail.smtp.starttls.enable","true");
	        props.put("mail.smtp.host", host);
	        props.put("mail.smtp.port", "587");
	        props.put("mail.debug", "true");
	        props.put("mail.smtp.auth", "true");
	       Authenticator auth = new SMTPAuthenticator();
try {
			InternetAddress from = new InternetAddress("",email);
	        	
	        	Session session = Session.getInstance(props,auth);
	        	MimeMessage msg=new MimeMessage(session);	        	
	        	msg.setFrom(from);
	        	msg.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
	        	msg.setSubject("KIA INQUIRY");
	        	String message_text=feedBackMessage.concat("r\n").concat(phone);     

	        	MimeBodyPart message_body=new MimeBodyPart();
	        	message_body.setContent(message_text,"text/plain");
	        	     
	             
	             Multipart multipart_message=new MimeMultipart();
	             multipart_message.addBodyPart(message_body);
	            msg.setContent(multipart_message);
	        	
	            Transport.send(msg);
	            System.out.println("Email Sent out");
	        	
	        	
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
	        





		
	}
       
	
	public static void main(String args[])
	{
		sendMail("krishnaveni@krishnaveni.com","Looking for Java Expert","214-767-3234");
	
	sendResume(new File("C:/test.txt"));
	}


	public static void sendResume(File savedFile) {
	
		
		


		String to="junaid.jp@gmail.com";
        // SUBSTITUTE YOUR ISP'S MAIL SERVER HERE!!!
        //String host = "smtp.jdnenterprises.com";
        String host="smtp.gmail.com";
        //java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        // Create properties, get Session
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");
        props.put("mail.debug", "true");
        props.put("mail.smtp.auth", "true");
        Authenticator auth = new SMTPAuthenticator();
try {
        	
        	
        	Session session = Session.getInstance(props, auth);
        	MimeMessage msg=new MimeMessage(session);
        	msg.setFrom(new InternetAddress("","junaid"));
        	msg.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
        	msg.setSubject("SomeBody Posted a Resume");
        	String message_text="Download this Resume";     

        	MimeBodyPart message_body=new MimeBodyPart();
        	message_body.setContent(message_text,"text/plain");
        	//
        
        	 /*
        	  * Create a attachment 
        	  */
        	
        	//File file=new File(finfo.getFile());
        	DataSource file_data_source=new FileDataSource(savedFile);
        	DataHandler file_data_handler=new DataHandler(file_data_source);
        	MimeBodyPart file_attachmentResume=new MimeBodyPart();
        	file_attachmentResume.setFileName(savedFile.getName());
        	file_attachmentResume.setDataHandler(file_data_handler);
       
        	
        	 
             
             Multipart multipart_message=new MimeMultipart();
             multipart_message.addBodyPart(message_body);
             multipart_message.addBodyPart(file_attachmentResume);	
             
        	//msg.setText("");
             msg.setContent(multipart_message);
        	Transport.send(msg);
        	
        	
        }
        catch(Exception e)
        {
        	
        }
        




}
		
	}







