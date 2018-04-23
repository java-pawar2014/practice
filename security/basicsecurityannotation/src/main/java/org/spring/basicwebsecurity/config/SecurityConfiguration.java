package org.spring.basicwebsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * <p>
 * The first step is to create our Spring Security Java Configuration.<br>
 * The configuration creates a Servlet Filter known as the
 * springSecurityFilterChain which is responsible for all the security
 * (protecting the application URLs, validating submitted username and
 * passwords, redirecting to the log in form, etc) within your application.
 * </p>
 * 
 * 
 * @author bpawar
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	/**
	 * <p>
	 * There really isn’t much to this configuration, but it does a lot. You can
	 * find a summary of the features below:<br>
	 * <li>Require authentication to every URL in your application</li>
	 * <li>Generate a login form for you</li>
	 * <li>Allow the user with the Username user and the Password password to
	 * authenticate with form based authentication</li>
	 * <li>Allow the user to logout</li>
	 * <li>and many more...</li>
	 * </p>
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("dba").password("password").roles("DBA");
	}

	/**
	 * <p>
	 * The default configuration :
	 * <li>Ensures that any request to our application requires the user to be
	 * authenticated</li>
	 * <li>Allows users to authenticate with form based login</li>
	 * <li>Allows users to authenticate with HTTP Basic authentication</li>
	 * </p>
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')").antMatchers("/dba/**")
				.access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')").antMatchers("/user/**")
				.access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')").and().formLogin();

		http.logout().logoutUrl("/logout").logoutSuccessUrl("/welcome").invalidateHttpSession(true).permitAll(true);

	}

}
