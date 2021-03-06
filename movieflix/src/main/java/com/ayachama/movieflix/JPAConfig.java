package com.ayachama.movieflix;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.logging.SessionLog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		System.out.println("## entityManagerFactory");
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan("com.ayachama.movieflix.entity");
		emf.setJpaVendorAdapter(new EclipseLinkJpaVendorAdapter());
		emf.setJpaProperties(jpaProperties());
		return emf;
	}

	@Bean
	public DataSource dataSource() {
		System.out.println("## dataSource");
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/movieflix-db?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean
	public PlatformTransactionManager txnManager(EntityManagerFactory emf) {
		System.out.println("## txnManager");
		JpaTransactionManager txnManager = new JpaTransactionManager(emf);
		return txnManager;
	}

	private Properties jpaProperties() {
		System.out.println("## jpaProperties");
		Properties props = new Properties();
		props.setProperty(PersistenceUnitProperties.DDL_GENERATION, PersistenceUnitProperties.CREATE_ONLY);
		props.setProperty(PersistenceUnitProperties.LOGGING_LEVEL, SessionLog.FINE_LABEL);
		props.setProperty(PersistenceUnitProperties.WEAVING, "false");
		return props;
	}

}
