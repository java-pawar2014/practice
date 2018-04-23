package org.spring.basicwebsecurity.initializer;

import org.spring.basicwebsecurity.config.SecurityConfiguration;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * <p>
 * The SecurityWebApplicationInitializer will do the following things:<br>
 * <li>Automatically register the springSecurityFilterChain Filter for every URL
 * in your application</li>
 * <li>Add a ContextLoaderListener that loads the SecurityConfiguration.</li>
 * </p>
 * 
 * @author bpawar
 *
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

	// public SecurityWebApplicationInitializer() {
	//
	// super(SecurityConfiguration.class);
	// }

}
