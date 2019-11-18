package com.owner.backproject.service;

import com.owner.backproject.domain.model.email.MailDTO;

import javax.mail.MessagingException;

public interface SendEmailService {

    public void sendEmail(MailDTO mailDTO) throws MessagingException;
}
