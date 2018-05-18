package com.safecode.amber.controller;

import com.safecode.amber.bean.users;
import com.safecode.amber.dao.usersMapper;
import com.safecode.amber.util.emailcode;
import com.safecode.amber.util.sendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class Userlogin {
    @Autowired
    usersMapper kf;
    @Autowired
    private JavaMailSender sender;
    private String s1;

    @RequestMapping(value = "/login")
    public Map login(String email, String passwd, HttpSession session) {
        System.out.println("email帐号:" + email + "   " + "密码" + passwd);
        Map k = new HashMap();
        if (email.length() > 0 && passwd.length() > 0) {
            List<users> users = kf.selectByExample(null);
            System.out.println(users.get(0).toString());
            System.out.println("index");
            session.setAttribute("user", email);
            k.put("ret", "1");
            k.put("msg", "登录成功啦");
//            user="zcj";
            return k;
        } else {
            k.put("ret", "2");
            k.put("msg", "一定是发生了什么");
            return k;
        }

    }

    @RequestMapping(value = "/registered")
    public Map registered(users u, String code, HttpSession session) {
        Map m = new HashMap();
        session.setMaxInactiveInterval(600);
        if (session.getAttribute("code") == null) {
            System.out.println("session为空");
            m.put("ret", "3");
            m.put("msg", "请先获取验证码");
            return m;
        }
        if (session.getAttribute("code").equals(code)) {
            System.out.println("进入注册");
            System.out.println(u.toString());
            m.put("ret", "1");
            m.put("msg", "成功");
            return m;
        } else {
            m.put("ret", "2");
            m.put("msg", "注册失败，验证码无效");
            return m;
        }
    }

    @RequestMapping(value = "/xxx")
    public void registeredd(users u) {
        System.out.println("进入注册");
        System.out.println(u.toString());
    }

    @RequestMapping("/email")
    public void sendSimple(String name, HttpSession session) {
        String to = name;
        String title = "欢迎注册Amber论坛账号";
        emailcode c = new emailcode();
        s1 = c.GetCode();
        session.setAttribute("code", s1);
        System.out.println(s1);
        String content = "感谢您注册我们论坛，此验证码为验证邮箱使用，请不要告诉他人，在十分钟内使用" + "\n" + "您的邮箱验证码为：" + s1;
        sendEmail s = new sendEmail();
        s.sendSimple(to, title, content, sender);
    }

    @RequestMapping("/submmit")
    public ModelAndView submit() {
        System.out.println(s1);
        ModelAndView m = new ModelAndView("/Amberhtml/index");
        return m;
    }

    @RequestMapping("pages")//页面跳转
    public ModelAndView userloginpages(ModelAndView m, String page, @SessionAttribute(value = "user") String name) {
        System.out.println("session 哈哈哈名字" + name);
        if (name != null) {
            m.setViewName("/Amberhtml/" + page);
        } else {
            m.setViewName("/pages/Amberhtml/login.html");
        }
        return m;
    }

}
