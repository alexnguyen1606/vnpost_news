package com.vnpost.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = {"com.vnpost.repository"})
@EnableTransactionManagement
public class JPAConfig {
    //Create Bean to Config DataBase
    @Bean
    public DataSource dataSourceMySQL(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/vnpost_news");
        dataSource.setUsername("root");
        dataSource.setPassword("1234");
        return dataSource;
    }
//    @Bean
//    public DataSource dataSourceMSSQL(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        dataSource.setUrl("jdbc:sqlserver://localhost;DatabaseName=vnpost");
//        dataSource.setUsername("sa");
//        dataSource.setPassword("1234");
//        return dataSource;
//    }
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSourceMySQL());
        entityManager.setPersistenceUnitName("persistence");
        JpaVendorAdapter jpaVendorAdapter =new HibernateJpaVendorAdapter();
        entityManager.setJpaVendorAdapter(jpaVendorAdapter);
        entityManager.setJpaProperties(addMySQlProperties());
        return entityManager;
    }
    @Bean
    public Properties addMySQlProperties() {
        Properties properties = new Properties();
       // properties.setProperty("hibernate.hbm2ddl.auto", "create");
        //properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        properties.setProperty("hibernate.show_sql","false");
        properties.setProperty("hibernate.format_sql","true");
        properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
        return properties;
    }

}
