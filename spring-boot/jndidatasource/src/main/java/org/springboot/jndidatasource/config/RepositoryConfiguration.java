package org.springboot.jndidatasource.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.jndi.JndiTemplate;

@SpringBootConfiguration
public class RepositoryConfiguration {

	/*@Bean
	public JndiObjectFactoryBean jndiObjectFactoryBean() {
		JndiObjectFactoryBean jndiObjectFactoryBean = null;

		jndiObjectFactoryBean = new JndiObjectFactoryBean();
		jndiObjectFactoryBean.setResourceRef(true);
		jndiObjectFactoryBean.setJndiName("jdbc/application");
		jndiObjectFactoryBean.setLookupOnStartup(true);
		return jndiObjectFactoryBean;
	}

	@Bean
	public DataSource dataSource(@Autowired JndiObjectFactoryBean bean) {
		DataSource dataSource = null;
		JndiTemplate jndi = bean.getJndiTemplate();
		try {
			
			dataSource = jndi.lookup("java:comp/env/jdbc/application", DataSource.class);
		} catch (NamingException e) {
		}
		return dataSource;
	}*/
}
