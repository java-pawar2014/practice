package com.agsft.thymeleaf.service;

import java.io.IOException;

import javax.mail.MessagingException;

import com.agsft.thymeleaf.dto.Mail;

/**
 * @author bpawar
 * @since 07-Sep-2018
 */
public interface EmailService {

	public void sendSimpleMessage(Mail mail) throws MessagingException, IOException;

}
