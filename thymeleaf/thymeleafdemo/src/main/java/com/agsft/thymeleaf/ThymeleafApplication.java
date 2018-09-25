package com.agsft.thymeleaf;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.agsft.thymeleaf.dto.Mail;
import com.agsft.thymeleaf.service.EmailService;

@SpringBootApplication
public class ThymeleafApplication implements ApplicationRunner {

	private static Logger log = LoggerFactory.getLogger(ThymeleafApplication.class);

	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {
		log.info("Sending Email with Thymeleaf HTML Template Example");

		Mail mail = new Mail();
//		mail.setFrom("Thymeleaf");
		mail.setTo("bpawar@agsft.com");
		mail.setSubject("Sending Email with Thymeleaf HTML Template Example");

		Map<String, Object> model = new HashMap<>();
		model.put("name", "Balasaheb");
		model.put("link", "www.google.com");
//		model.put("location", "India");
//		model.put("signature", "http://wwww.agsft.com");
		mail.setModel(model);
		emailService.sendSimpleMessage(mail);
	}
}
