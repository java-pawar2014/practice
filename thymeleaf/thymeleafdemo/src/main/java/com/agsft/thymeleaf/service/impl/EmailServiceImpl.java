package com.agsft.thymeleaf.service.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.agsft.thymeleaf.dto.Mail;
import com.agsft.thymeleaf.service.EmailService;

/**
 * @author bpawar
 * @since 07-Sep-2018
 */
@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	private SpringTemplateEngine templateEngine;

	@Override
	public void sendSimpleMessage(Mail mail) throws MessagingException, IOException {
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name());
//		ClassPathResource logo = new ClassPathResource("logo.png");
//		helper.addInline("logo", logo);
//		helper.addAttachment("logo.png", logo);
		Context context = new Context();
		context.setVariables(mail.getModel());
//		context.setVariable("logo", logo);
		String html = templateEngine.process("reset-password-link", context);

		helper.setTo(mail.getTo());
		helper.setText(html, true);
		helper.setSubject(mail.getSubject());
//		helper.setFrom("Metris");

		emailSender.send(message);

	}

}
