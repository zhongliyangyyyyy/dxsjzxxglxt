package com.liyuan.utils;

import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;/**
 * 邮件发送操作类
 * 
 * @author zhangdi
 * 
 */
public class MailOperation {

    /**
     * 发送邮件
     * @param user 发件人邮箱
     * @param password 授权码（注意不是邮箱登录密码）
     * @param host 
     * @param from 发件人
     * @param to 接收者邮箱
     * @param subject 邮件主题
     * @param content 邮件内容
     * @return success 发送成功 failure 发送失败
     * @throws Exception
     */
    public static boolean sendMail(String user, String password, String host,
            String from, String to, String subject, String content)
            throws Exception {
        if (to != null){
        	//得到系统的属性
            Properties props = System.getProperties();
            //设置主机名
            props.put("mail.smtp.host", host);
            //需要验证
            props.put("mail.smtp.auth", "true");
            MailAuthenticator auth = new MailAuthenticator();
            MailAuthenticator.USERNAME = user;
            MailAuthenticator.PASSWORD = password;
            Session session = Session.getInstance(props, auth);
            session.setDebug(true);
            try {
                MimeMessage message = new MimeMessage(session);
                //设置发件人邮箱
                message.setFrom(new InternetAddress(from));
                if (!to.trim().equals(""))
                	//设置收件人邮箱
                    message.addRecipient(Message.RecipientType.TO,
                            new InternetAddress(to.trim()));
                //设置邮件主题
                message.setSubject(subject);
                MimeBodyPart mbp1 = new MimeBodyPart(); // 正文
                mbp1.setContent(content, "text/html;charset=utf-8");
                Multipart mp = new MimeMultipart(); // 整个邮件：正文+附件
                mp.addBodyPart(mbp1);
                message.setContent(mp);
                //设置发送日期
                message.setSentDate(new Date());
                message.saveChanges();
                Transport trans = session.getTransport("smtp");
                trans.send(message);
                System.out.println(message.toString());
            } catch (Exception e){
                e.printStackTrace();
                return false;
            }
            return true;
        }else{            
            return false;
        }
    }

}