/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.artisanet.service;



import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Bayrem
 */
public class JavaMailAPI {
    
    public static void sendMail(String recepient) throws Exception{
        Properties prop = new Properties();
        
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        
        String myAccount = "artisanet.website@gmail.com";
        String pwd = "123456789aazz";
        
        Session session;
        session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                
                return new PasswordAuthentication(myAccount, pwd);
                
            }
        });
        
        
        Message message = prepareMessage(session, myAccount, recepient);   
        Transport.send(message);
    }

    private static Message prepareMessage(Session session, String myAccount, String recepient) {
        try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(myAccount));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
        message.setSubject("Nouvelle Reclamation");
        message.setText("Bonjour, \n Vous avez une nouvelle reclamation");
        return message;
        }
        catch (Exception e) {
            System.out.println("errrr");
        }
        return null;
    }
    
    
    
}
