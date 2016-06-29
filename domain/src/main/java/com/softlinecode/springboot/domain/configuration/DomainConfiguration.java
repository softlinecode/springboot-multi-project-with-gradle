package com.softlinecode.springboot.domain.configuration;

import com.softlinecode.springboot.domain.Domain;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author softlinecode@gmail.com
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackageClasses = Domain.class)
@EnableJpaRepositories(basePackageClasses = { Domain.class })
public class DomainConfiguration extends WebMvcConfigurerAdapter {

}
