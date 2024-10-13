package org.yassine.webservice.server;

import jakarta.persistence.EntityManagerFactory;
import jakarta.xml.ws.Endpoint;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.yassine.webservice.services.impl.ProductServiceImpl;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "org.yassine.webservice")
@EnableJpaRepositories(basePackages = "org.yassine.webservice.repositeries")
@EnableTransactionManagement
public class ServerWS {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.hibernate.dialect.MariaDBDialect");
        dataSource.setUrl("jdbc:mysql://localhost:3306/ProductBase");
        dataSource.setUsername("root");
        dataSource.setPassword("helloyassine");
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("org.yassine.webservice.entities");
        factory.setDataSource(dataSource);
        return factory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServerWS.class);

        ProductServiceImpl productService = context.getBean(ProductServiceImpl.class);

        String url = "http://localhost:8080/webservice";
        System.out.println("WebService starting at " + url);

        Endpoint.publish(url, productService);

        System.out.println("WebService started successfully.");
    }

}
