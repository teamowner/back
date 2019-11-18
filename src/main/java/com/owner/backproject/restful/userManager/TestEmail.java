package com.owner.backproject.restful.userManager;


import com.owner.backproject.domain.model.email.MailDTO;
import com.owner.backproject.service.SendEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TestEmail {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    SendEmailService sendEmailService;

    @Test
    public void testSend() throws MessagingException {

        MailDTO mailDTO = new MailDTO();
        mailDTO.setFrom(from);
        String[] to = new String[2];
        to[0] = "vndhnl@cn.ibm.com";
        to[1] = "478703766@qq.com";
        mailDTO.setTo(to);
        mailDTO.setText("测试发邮件");
        mailDTO.setSubject("第一次");

        sendEmailService.sendEmail(mailDTO);
    }
}
