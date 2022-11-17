package com.example.gof.facade;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class FacadeRunner {
    /*
    복잡한 서브 시스템 의존성을 최소화하는 방법.
    클라이언트가 사용해야하는 복잡한 서브 시스템 의존성을 간단한 인터페이스로 추상화할 수 있다.
    장점 : 서브시스템에 대한 코드를 한 곳에 몰아줄 수 있다.
    단점 : 퍼사드 자체가 서브시스템에 대한 의존성을 모두 가지게 된다
        } catch (MessagingException e){
            e.printStackTrace();.

     */
    public static void run(){
        /* 퍼사드 적용 전
        String to = "keesun@whiteship.me";
        String from = "whiteship@whiteship.me";
        String host = "127.0.0.1";

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getDefaultInstance(properties);

        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Test Mail from Java Program");
            message.setText("message");

            Transport.send(message);
        }
         */

        /* 퍼사드 적용
        EmailSettings emailSettings = new EmailSettings();
        emailSettings.setHost("127.0.0.1");

        EmailSender emailSender = new EmailSender(emailSettings);

        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setFrom("whiteship@whiteship.me");
        emailMessage.setTo("keesun@whiteship.me");
        emailMessage.setTitle("Test Mail from Java Program");
        emailMessage.setText("message");

        emailSender.sendEmail(emailMessage);
         */
    }
}
