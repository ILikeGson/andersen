package com.andersen.shop.config;

import com.andersen.shop.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.andersen.shop.dao", "com.andersen.shop.service"})
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, username, password);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }

    @Autowired
    @Bean
    public TransactionManager getTransactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
        builder.scanPackages("com.andersen.shop.model");
        builder.addProperties(getHibernateProperties());

        return builder.buildSessionFactory();
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.put("connection.driver_class", "com.mysql.cj.jdbc.Driver ");
        properties.put("dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        properties.put("hibernate.connection.url", "jdbc:mysql://localhost/shop");
        properties.put("hibernate.connection.username", "root");
        properties.put("hibernate.connection.password", "password");
        properties.put("hibernate.hbm2ddl.auto", "create");
        properties.put("show_sql", "true");

        MetadataSources metadata = new MetadataSources(
                new StandardServiceRegistryBuilder()
                        .applySettings(properties)
                        .build());
        metadata.addAnnotatedClass(Product.class);
        metadata.addAnnotatedClass(Thing.class);
        metadata.addAnnotatedClass(Food.class);
        metadata.addAnnotatedClass(Country.class);
        metadata.addAnnotatedClass(Currency.class);
        metadata.addAnnotatedClass(InternetShopBucket.class);
        metadata.addAnnotatedClass(User.class);
        metadata.addAnnotatedClass(Order.class);
        metadata.addAnnotatedClass(InternetShop.class);
        metadata.addAnnotatedClass(Warehouse.class);
        return properties;
    }
}
