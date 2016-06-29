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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.softlinecode.springboot.domain.springweb.Springweb;

/**
 * @author softlinecode@gmail.com
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactorySpringweb", transactionManagerRef = "transactionManagerSpringweb", basePackages = {
	"com.sk.prototype.repository.other" })
public class SpringwebRepositoryConfig {
	@Inject
	private JpaVendorAdapter jpaVendorAdapter;

	@Inject
	private JpaProperties jpaProperties;

	@Inject
	@Qualifier("springwebDataSource")
	private DataSource springwebDataSource;

	@Bean(name = "entityManagerSpringweb")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return entityManagerFactorySpringweb(builder).getObject().createEntityManager();
	}

	@Bean(name = "entityManagerFactorySpringweb")
	public LocalContainerEntityManagerFactoryBean entityManagerFactorySpringweb(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(springwebDataSource).properties(getVendorProperties(springwebDataSource)).packages(
			Springweb.class).persistenceUnit("otherPersistenceUnit").build();
	}

	private Map<String, String> getVendorProperties(DataSource dataSource) {
		return jpaProperties.getHibernateProperties(dataSource);
	}

	@Bean(name = "transactionManagerSpringweb")
	PlatformTransactionManager transactionManagerSpringweb(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactorySpringweb(builder).getObject());
	}
}
