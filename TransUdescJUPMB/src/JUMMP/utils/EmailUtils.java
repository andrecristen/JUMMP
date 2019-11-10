/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUMMP.utils;

import JUMMP.mail.Email;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author andre
 */
public class EmailUtils {

    Properties props = new Properties();

    public EmailUtils() {
        props.put("mail.smtp.host", Email.getSMTP_HOST());
        props.put("mail.smtp.socketFactory.port", Email.getSMTP_SOCKET_PORT());
        props.put("mail.smtp.socketFactory.class", Email.getSMTP_CLASS());
        props.put("mail.smtp.auth", Email.getSMTP_AUTH());
        props.put("mail.smtp.port", Email.getSMTP_PORT());
    }

    public void send(String toEmail, String title, String messageText) {
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Email.getEMAIL_LOGIN(), Email.getEMAIL_PASSWORD());
            }
        });
        session.setDebug(true);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Email.getEMAIL_LOGIN()));
            Address[] toUser = InternetAddress.parse(toEmail);
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(title);
            message.setText(messageText);
            Transport.send(message);
            new EventMessage("Sucesso ao enviar email para: " + toEmail, EventMessage.getTIPO_SUCESSO());
        } catch (MessagingException e) {
            new EventMessage("Erro ao enviar email para: " + toEmail + ". Erro recebido: '" + e.getMessage() + "'.", EventMessage.getTIPO_ERRO());
        }
    }
}
