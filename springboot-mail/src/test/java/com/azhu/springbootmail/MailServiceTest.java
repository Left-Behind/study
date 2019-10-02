package com.azhu.springbootmail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

/**
 * @author Azhu
 * @date 2019-10-02
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMailApplication.class)
public class MailServiceTest {

    @Autowired
    private MailService mailService;


    @Autowired
    MyConfiguration myConfiguration;

    @Test
    public void T() {
        System.out.printf("sssssssss");
    }
    @Test
    public void sendMail() {
        mailService.sendMail("2576419596@qq.com", "测试邮件", "hello this test email");
    }

    @Test
    public void sendHtmlMail() {
        String html = "<html>\n" +
                "<body>\n" +
                "<h2>this a html email</h2>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("2576419596@qq.com", "测试HTML邮件", html);
    }

    @Test
    public void sendAttachmentsMail() throws IOException {
        File directory = new File("");//参数为空
        String courseFile = directory.getCanonicalPath();
        String author =directory.getAbsolutePath();
        System.out.println(courseFile);
        System.out.println(author);
        author=author+"\\src\\main\\resources\\static\\Azhu.jpg";
        String filePath =author;
        System.out.println(filePath);
        mailService.sendAttachmentsMail("2576419596@qq.com", "测试携带附件的邮件", "这是携带附件的邮件，请注意查收", filePath);
    }

    @Test
    public void sendInlineResourceMail() throws IOException {
        File directory = new File("");//参数为空
        String courseFile = directory.getCanonicalPath();
        String author =directory.getAbsolutePath();
        System.out.println(courseFile);
        System.out.println(author);
        author=author+"\\src\\main\\resources\\static\\Azhu.jpg";
        String filePath =author;
        String to = "2576419596@qq.com";
        String subject = "这是携带内联资源的邮件";
        String resId = "001";
        String resPath = filePath;
        String content = "<html>\n" +
                "<body>\n" +
                "这是带图片的邮件<img src=\'resId:" + resId + "\'>" +
                "</body>\n" +
                "</html>";
        mailService.sendInlineResourceMail(to, subject, content, resPath, resId);
    }

    @Test
    public void sendTemplateMail() {
        int code = (int) (Math.random() * 9 + 1) * 100000;
        mailService.sendTemplateMail("2576419596@qq.com", "这是模板邮件", String.valueOf(code));
    }
}