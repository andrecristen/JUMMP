/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUMMP.mail;

/**
 *
 * @author andre
 */
public class Email {
    final static String SMTP_HOST = "smtp.gmail.com";
    final static String SMTP_SOCKET_PORT = "465";
    final static String SMTP_CLASS = "javax.net.ssl.SSLSocketFactory";
    final static String SMTP_AUTH = "true";
    final static String SMTP_PORT = "465";
    final static String EMAIL_LOGIN = "seulogin@gmail.com";
    final static String EMAIL_PASSWORD = "suasenha";
    final static boolean SESSION_DEBUG = false;

    public static String getSMTP_HOST() {
        return SMTP_HOST;
    }

    public static String getSMTP_SOCKET_PORT() {
        return SMTP_SOCKET_PORT;
    }

    public static String getSMTP_CLASS() {
        return SMTP_CLASS;
    }

    public static String getSMTP_AUTH() {
        return SMTP_AUTH;
    }

    public static String getSMTP_PORT() {
        return SMTP_PORT;
    }

    public static String getEMAIL_LOGIN() {
        return EMAIL_LOGIN;
    }

    public static String getEMAIL_PASSWORD() {
        return EMAIL_PASSWORD;
    }

    public static boolean isSESSION_DEBUG() {
        return SESSION_DEBUG;
    }
    
    
}

