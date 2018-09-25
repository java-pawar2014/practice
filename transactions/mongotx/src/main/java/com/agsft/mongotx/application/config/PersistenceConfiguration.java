package com.agsft.mongotx.application.config;

import javax.persistence.EntityManagerFactory;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootConfiguration
@EnableTransactionManagement(mode = AdviceMode.PROXY, proxyTargetClass = true, order = Ordered.LOWEST_PRECEDENCE)
public class PersistenceConfiguration {

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
