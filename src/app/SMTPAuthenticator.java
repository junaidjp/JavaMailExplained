package app;

import javax.mail.PasswordAuthentication;



public class SMTPAuthenticator extends javax.mail.Authenticator {
 
		public PasswordAuthentication getPasswordAuthentication() {
			String username ="adm.kiaconsulting@gmail.com" ;
			String  password="kiaconsulting";
			return new PasswordAuthentication(username, password);
		}
	}

