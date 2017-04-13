package za.co.discovery.repository.config;

import org.hsqldb.util.DatabaseManagerSwing;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by tinashehondo on 4/6/17.
 */
@Configuration
@PropertySource({"classpath:persistence.properties"})
@EnableJpaRepositories(basePackages = {"za.co.discovery.repository"})
@EnableTransactionManagement
public class DataDaoConfiguration {

    @Resource
    private Environment env;

    @PostConstruct
    public void startDBManager() {

        //hsqldb
       // DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:mem:testdb", "--user", "sa", "--password", "" });

        //derby
        DatabaseManagerSwing.main(new String[] { "--url", "jdbc:derby:memory:testdb;create=true", "--user", "", "--password", "" });

        //h2
        //DatabaseManagerSwing.main(new String[] { "--url", "jdbc:h2:mem:testdb", "--user", "sa", "--password", "" });

    }


    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                //.generateUniqueName(true)
                .setType(EmbeddedDatabaseType.DERBY)
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                //.addScript("/db/sql/create-route.sql")
                //.addScripts("/db/sql/create-db.sql", "/db/sql/insert-data.sql")
                .build();
    }

    private Properties hibProperties() {
        Properties properties = new Properties();

        properties.setProperty("hibernate.show_sql", env.getProperty("jpa.debug"));
        properties.put("hibernate.dialect", env.getProperty("jpa.dialect"));
        properties.put("hibernate.hbm2ddl.auto",env.getProperty("hibernate.hbm2ddl.auto"));//create tables if not exist
        return properties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabase(Database.DERBY);
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("za.co.discovery.model");
        factory.setDataSource(dataSource());
        factory.setJpaProperties(hibProperties());

        return factory;
    }


    @Bean
    public PlatformTransactionManager transactionManager() {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return txManager;
    }

}
