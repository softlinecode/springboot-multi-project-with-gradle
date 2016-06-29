package com.softlinecode.springboot.domain.configuration;

import java.util.Map;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.softlinecode.springboot.domain.springboot.Springboot;

/**
 * @author softlinecode@gmail.com
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactorySpringboot", transactionManagerRef = "transactionManagerSpringboot", basePackageClasses = {
	Springboot.class })
public class SpringbootRepositoryConfig {
	@Inject
	private JpaProperties jpaProperties;

	@Inject
	@Qualifier("springbootDataSource")
	private DataSource springbootDataSource;

	@Bean(name = "entityManagerSpringboot")
	@Primary
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return entityManagerFactorySpringboot(builder).getObject().createEntityManager();
	}

	@Bean(name = "entityManagerFactorySpringboot")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactorySpringboot(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(springbootDataSource).properties(getVendorProperties(springbootDataSource)).packages(
			Springboot.class).persistenceUnit("mainPersistenceUnit").build();
	}

	private Map<String, String> getVendorProperties(DataSource dataSource) {
		return jpaProperties.getHibernateProperties(dataSource);
	}

	@Bean(name = "transactionManagerSpringboot")
	@Primary
	PlatformTransactionManager transactionManagerSpringboot(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactorySpringboot(builder).getObject());
	}
}
