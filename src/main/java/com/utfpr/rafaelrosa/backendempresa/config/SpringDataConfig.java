package com.utfpr.rafaelrosa.backendempresa.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories("com.utfpr.rafaelrosa.backendempresa.repository")
@EnableTransactionManagement
public class SpringDataConfig {

    @Bean
    public DataSource dataSource(){

        HikariDataSource ds = new HikariDataSource();

        ds.setUsername("root");
        ds.setPassword("root");
        ds.setJdbcUrl("jdbc:h2:mem:empresadb");
        ds.setDriverClassName("org.h2.Driver");

        return ds;
    }

//    @Bean
//    public DataSource dataSource(){
//
//        HikariDataSource ds = new HikariDataSource();
//
//        ds.setUsername("root");
//        ds.setPassword("admin");
//        ds.setJdbcUrl("jdbc:mariadb://localhost:3306/Atividade02");
//        ds.setDriverClassName("org.mariadb.jdbc.Driver");
//
//        return ds;
//    }

    @Bean
    public EntityManagerFactory entityManagerFactory(){

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(false);
        vendorAdapter.setShowSql(false);

        factory.setDataSource(dataSource());
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.utfpr.rafaelrosa.backendempresa.entity");
        factory.afterPropertiesSet();

        return factory.getObject();

    }

    @Bean
    public PlatformTransactionManager transactionManager(){

        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory());
        manager.setJpaDialect(new HibernateJpaDialect());

        return manager;
    }
}
