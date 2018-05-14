package org.springboot.jndidatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories
@EnableSwagger2
@EnableAspectJAutoProxy
public class JNDIDataSourceApplicationStarter {

	public static void main(String[] args) {

		SpringApplication.run(JNDIDataSourceApplicationStarter.class, args);
	}
	
	
}
