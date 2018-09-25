package com.springboot.javamail.web.controller;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.javamail.web.bean.EmailBean;

@Controller
@RequestMapping(path = { "/user" })
public class MailController {

	private Logger logger = LoggerFactory.getLogger(MailController.class);

	@Autowired
	private JavaMailSender javaMailSender;

	@PostMapping(path = { "/email/simple" }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> sendSimpleEmail(@RequestBody @Valid EmailBean email) {
		ResponseEntity<String> response = null;
		if (email != null) {
			try {
				SimpleMailMessage message = new SimpleMailMessage();
				message.setTo(email.getTo());
				message.setBcc(email.getBcc());
				message.setCc(email.getCc());
				message.setText(email.getBody());
				message.setSubject(email.getSubject());
				JavaMailSenderImpl impl = (JavaMailSenderImpl) javaMailSender;
				logger.info(impl.getHost() + " $ " + impl.getPassword() + " $ " + impl.getPort() + " $ "
						+ impl.getProtocol() + " $ " + impl.getUsername());
				javaMailSender.send(message);
				response = new ResponseEntity<String>("Email send successfully", HttpStatus.OK);
			} catch (Throwable cause) {
				cause.printStackTrace();
				response = new ResponseEntity<String>("Failed to send email, reason is : " + cause.getMessage(),
						HttpStatus.OK);
			}
		} else {
			response = new ResponseEntity<String>("Email contents to, body required", HttpStatus.OK);
		}
		return response;
	}

	@PostMapping(path = { "/email/mime" }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> sendMimeEmail(@RequestBody @Valid EmailBean email) {
		ResponseEntity<String> response = null;

		JavaMailSenderImpl senderImpl = (JavaMailSenderImpl) javaMailSender;
		if (email != null) {
			try {

				MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
					@Override
					public void prepare(MimeMessage mimeMessage) throws Exception {
						Address[] addresss = new InternetAddress[email.getTo().length];
						for (int idCount = 0; idCount < email.getTo().length; idCount++) {
							addresss[idCount] = new InternetAddress(email.getTo()[idCount]);
						}
						mimeMessage.setRecipients(Message.RecipientType.TO, addresss);
						mimeMessage.setFrom(new InternetAddress(senderImpl.getUsername().split("@")[0].toUpperCase()));
						mimeMessage.setText(email.getBody());
						mimeMessage.setSubject(email.getSubject());
					}
				};

				logger.info(senderImpl.getHost() + " $ " + senderImpl.getPassword() + " $ " + senderImpl.getPort()
						+ " $ " + senderImpl.getProtocol() + " $ " + senderImpl.getUsername());
				javaMailSender.send(messagePreparator);
				response = new ResponseEntity<String>("Email send successfully", HttpStatus.OK);
			} catch (Throwable cause) {
				cause.printStackTrace();
				response = new ResponseEntity<String>("Failed to send email, reason is : " + cause.getMessage(),
						HttpStatus.OK);
			}
		} else {
			response = new ResponseEntity<String>("Email contents to, body required", HttpStatus.OK);
		}
		return response;
	}

	@PostMapping(path = { "/email/mime/attach" }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> sendMimeAttachmentEmail(@RequestBody @Valid EmailBean email) {
		ResponseEntity<String> response = null;

		if (email != null) {
			try {
				MimeMessage message = javaMailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message, true);
				helper.setTo(email.getTo());
				helper.setSubject(email.getSubject());
				helper.setText(email.getBody());
				FileSystemResource file = new FileSystemResource("/home/bpawar/Documents/practice/LICENSE");
				helper.addAttachment("attachment", file);
				javaMailSender.send(message);
				response = new ResponseEntity<String>("Email send successfully", HttpStatus.OK);
			} catch (Throwable cause) {
				cause.printStackTrace();
				response = new ResponseEntity<String>("Failed to send email, reason is : " + cause.getMessage(),
						HttpStatus.OK);
			}
		} else {
			response = new ResponseEntity<String>("Email contents to, body required", HttpStatus.OK);
		}
		return response;
	}
}
