package com.safecode.amber.controller;

import com.safecode.amber.bean.users;
import com.safecode.amber.dao.usersMapper;
import com.safecode.amber.util.emailcode;
import com.safecode.amber.util.sendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class Userlogin {
    @Autowired
    usersMapper k;
    @Autowired
    private JavaMailSender sender;
    private String s1;

    @RequestMapping(value = "/login")
    public ModelAndView login() {
        ModelAndView m = new ModelAndView("/Amberhtml/Tos");
        List<users> users = k.selectByExample(null);
        System.out.println(users.get(0).toString());
        System.out.println("index");
        return m;
    }

    @RequestMapping(value = "/registered")
    public ModelAndView registered() {
        ModelAndView m = new ModelAndView("/Amberhtml/registered");
        System.out.println("进入注册");
        return m;
    }

    @RequestMapping(value = "/xxx")
    public void registeredd(users u) {
        System.out.println("进入注册");
        System.out.println(u.toString());
    }

    @RequestMapping("/email")
    public void sendSimple(String name) {
        String to = name;
        String title = "欢迎注册Amber论坛账号";
        emailcode c = new emailcode();
        s1 = c.GetCode();
        System.out.println(s1);
        String content = "感谢您注册我们论坛，此验证码为验证邮箱使用，请不要告诉他人" + "\n" + "您的邮箱验证码为：" + s1;
        sendEmail s = new sendEmail();
        s.sendSimple(to, title, content, sender);
    }

    @RequestMapping("/submmit")
    public void submit() {
        System.out.println(s1);
    }

}
