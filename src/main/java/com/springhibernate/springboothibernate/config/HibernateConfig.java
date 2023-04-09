package com.springhibernate.springboothibernate.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Properties;

import javax.sql.DataSource;


@Configuration
public class HibernateConfig {

        @Autowired
        private Environment environment;

        @Bean
        public LocalSessionFactoryBean sessionFactory() {
            LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
            sessionFactory.setDataSource(dataSource());
            sessionFactory.setPackagesToScan("com.springhibernate.springboothibernate.entity");
            sessionFactory.setHibernateProperties(hibernateProperties());
            return sessionFactory;
        }

        @Bean
        public DataSource dataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(environment.getRequiredProperty("spring.datasource.driver-class-name"));
            dataSource.setUrl(environment.getRequiredProperty("spring.datasource.url"));
            dataSource.setUsername(environment.getRequiredProperty("spring.datasource.username"));
            dataSource.setPassword(environment.getRequiredProperty("spring.datasource.password"));
            return dataSource;
        }

        @Bean
        public PlatformTransactionManager hibernateTransactionManager() {
            HibernateTransactionManager transactionManager = new HibernateTransactionManager();
            transactionManager.setSessionFactory(sessionFactory().getObject());
            return transactionManager;
        }

        private final Properties hibernateProperties() {
            Properties hibernateProperties = new Properties();
            hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "none");
            hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
            hibernateProperties.setProperty("hibernate.show_sql", "true");
            return hibernateProperties;
        }

}
