/*package com.agsft.springaudit.config.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
public class ApplicationSecurityHandler extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("dba").password("password").roles("DBA");
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')").antMatchers("/dba/**")
				.access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')").antMatchers("/user/**")
				.access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')").and().formLogin();

		http.logout().logoutUrl("/logout").logoutSuccessUrl("/welcome").invalidateHttpSession(true).permitAll(true);

	}

}
*/