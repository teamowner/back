package com.owner.backproject.restful.userManager;


import com.owner.backproject.domain.config.BackConfig;
import com.owner.backproject.domain.model.email.MailDTO;
import com.owner.backproject.service.SendEmailService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestEmail {

    //private static final Logger log = LoggerFactory.getLogger(TestEmail.class);

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private BackConfig backConfig;

    @Autowired
    private Environment environment;

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

    @Test
    public void config(){
        //System.out.println("-------------" + backConfig.getName() + "====" + backConfig.getAge());
        //System.out.println("-------------" + environment.getProperty("spring.mail.host"));
        log.info("============" + backConfig.getName() + "====" + backConfig.getAge() );
        log.info("============" + environment.getProperty("spring.mail.host") );
    }
}
