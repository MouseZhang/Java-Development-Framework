package cn.ustb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class MailApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void simpleMail() {
        // 一个简单的邮件发送
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("SpringBoot重置密码的通知"); // 邮件主题
        mailMessage.setText("尊敬的用户您好：系统发现您的密码已经被重置，如果非本人操作请登录SpringBoot安全框架进行修改！");
        mailMessage.setTo("receiveAddress@example.com");
        mailMessage.setFrom("sendAddress@example.com");
        mailSender.send(mailMessage);
    }

    @Test
    void mimeMail() throws MessagingException {
        // 一个复杂的邮件发送
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 组装
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        // 正文
        helper.setSubject("SpringBoot重置密码的通知");
        helper.setText("<p style='color:red'>尊敬的用户您好：系统发现您的密码已经被重置，如果非本人操作请登录SpringBoot安全框架进行修改！</p>", true); // 第二个参数表示开启html模版
        // 附件
        helper.addAttachment("附件.png", new File("/Users/MouseZhang/imag.png"));
        helper.setTo("receiveAddress@example.com");
        helper.setFrom("sendAddress@example.com");
        mailSender.send(mimeMessage);
    }

}
