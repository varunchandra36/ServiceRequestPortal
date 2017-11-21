/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.varun.data;


import java.io.UnsupportedEncodingException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailDB{  

   
    public static void emailRecommendTrigger(String email){
        final String username = "varunchandra36@gmail.com";
        final String password = "123456789";
        
        String[] to = {email};
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        Session session=Session.getInstance(props,new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
            }
        });
        /*Session session=Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
            }
        });*/
        //Session session = Session.getInstance(props, null);

        try {

            Message message = new MimeMessage(session);
             InternetAddress me = new InternetAddress("defects@uncc.edu");
                try {
                    me.setPersonal("Defects Portal");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                message.setFrom(me);
            for (int i = 0; i < to.length; i++) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to[i]));
            }
            message.setSubject("Defect Reporting");
            message.setText("Hello"+",\n" +
                    "\nThank you for reporting defect. We will look into it. \n"+
                                        "\n\nRegards,\n" + "Team");

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}

