package com.liyuan.utils;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


/**
 * 发件人账号密码
 * @author 
 *
 */
public class MailAuthenticator extends   Authenticator{

    public static String USERNAME = "";
    public static String PASSWORD = "";

    public MailAuthenticator() {
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(USERNAME, PASSWORD);
    }

}