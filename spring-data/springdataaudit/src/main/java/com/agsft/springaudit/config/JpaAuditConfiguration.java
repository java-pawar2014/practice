package com.agsft.springaudit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef="AuditorAwareTriggerer")
public class JpaAuditConfiguration {
	
}
