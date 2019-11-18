package com.owner.backproject.service.impl;

import com.owner.backproject.domain.model.email.MailDTO;
import com.owner.backproject.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class SendEmailServiceImpl implements SendEmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public void sendEmail(MailDTO mailDTO) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(mailDTO.getFrom());
        helper.setTo(mailDTO.getTo());
        helper.setSubject(mailDTO.getSubject());
        helper.setText(mailDTO.getText(), true);
        //File file = new File(rscPath);
        //FileSystemResource res = new FileSystemResource(file);
        //helper.addInline(rscId, res);

        javaMailSender.send(message);

    }
}
