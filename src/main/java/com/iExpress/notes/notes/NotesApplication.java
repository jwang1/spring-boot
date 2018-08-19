package com.iExpress.notes.notes;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.properties.EncryptableProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = {
		NotesApplication.class,
		Jsr310JpaConverters.class
})
@EnableEncryptableProperties
public class NotesApplication implements WebMvcConfigurer {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("EST"));
	}

	public static void main(String[] args) {
		SpringApplication.run(NotesApplication.class, args);
	}

	@Value("${spring.datasource.driverClassName}")
    private String databaseDriverClassName;

	@Value("${spring.datasource.url}")
    private String datasourceUrl;

	@Value("${spring.datasource.username}")
    private String databaseUsername;

	private String databasePassword;

	@Bean
    public DataSource dataSource() throws IOException {
        org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
        ds.setDriverClassName(databaseDriverClassName);
        ds.setUrl(datasourceUrl);
        ds.setUsername(databaseUsername);
        ds.setPassword(getSecurePassword());

        return ds;
    }

    private String getSecurePassword() throws IOException {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();

        encryptor.setPassword(System.getProperty("jasypt.encryptor.password"));

        Properties props = new EncryptableProperties(encryptor);

        props.load(this.getClass().getClassLoader().getResourceAsStream("application.properties"));

        return props.getProperty("spring.datasource.password");
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
	    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
	    lci.setParamName("lang");
	    return lci;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

}
