package com.softlinecode.springboot.domain.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author softlinecode@gmail.com
 */
@Configuration
@EnableConfigurationProperties
public class DomainDatasourceProperties {

	@Bean(name = "springbootDataSource")
	@Qualifier("springbootDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.springboot")
	public DataSource springbootDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "springwebDataSource")
	@Qualifier("springwebDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.springweb")
	public DataSource springwebDataSource() {
		return DataSourceBuilder.create().build();
	}

}
