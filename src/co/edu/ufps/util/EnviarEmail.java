package co.edu.ufps.util;


import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Date;
import java.util.Properties;

import javax.websocket.Session;

import org.jboss.logging.Mesaage;


public class EnviarEmail{

	
	
	public void enviarEmail(String toAddress, String asunto, String mensaje){
 
        
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
 
        
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("sucorreo@gmail.com", "su contraseña");
            }
        };
 
        Session session = Session.getInstance(properties, auth);
 
       
        Mesaage msg = new MimeMessage(session);
 
      try {
    	  msg.setFrom(new InternetAddress("su correo"));
          InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
          msg.setRecipients(Message.RecipientType.TO, toAddresses);
          msg.setSubject(asunto);
          msg.setSentDate(new Date());
          msg.setText(mensaje);
   
          
          Transport.send(msg);
	} catch (Exception e) {
		e.printStackTrace();
	}
 
    }


}