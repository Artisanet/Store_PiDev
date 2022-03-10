/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Artisanet.models;

import java.net.PasswordAuthentication;
import java.util.Properties;

/**
 *
 * @author nourb
 */
public class Mail {
     public Mail() {
    }

    public void SendMail(String mail, String msg) {

        final String from = "nour.benmehrez@esprit.tn";
        final String password = "213JFT105";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(prop,
          new javax.mail.Authenticator() {protected PasswordAuthentication getPasswordAuthentication() {
                return null;
                        //new PasswordAuthentication(from, password);
            }
        });
       /* try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(
            Message.RecipientType.TO, InternetAddress.parse(mail)
            );
            message.setSubject("Bienvenue");
            message.setText(msg);
            Transport.send(message);
            System.out.println("Mail Sent");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("ereur de send mail");
        }*/
    }

    private static class javax {

        public javax() {
        }

        private static class mail {

            public mail() {
            }

            private static class Authenticator {

                public Authenticator() {
                }
            }
        }
    }

    


    private static class Session {

        private static Session getInstance(Properties prop, javax.mail.Authenticator authenticator) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public Session() {
        }
    }

    private static class InternetAddress {

        public InternetAddress() {
        }
    }


}


