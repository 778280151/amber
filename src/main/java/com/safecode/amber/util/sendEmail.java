package com.safecode.amber.util;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class sendEmail {

    /**
     * @param to      接受者
     * @param title   标题
     * @param content 内容
     * @param sender  发送请求类
     */
    public void sendSimple(String to, String title, String content, JavaMailSender sender) {
        final String from = "778280151@qq.com";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from); //发送者
        message.setTo(to); //接受者
        message.setSubject(title); //发送标题
        message.setText(content);  //发送内容
        sender.send(message);
        System.out.println("邮件发送成功");
    }

}
