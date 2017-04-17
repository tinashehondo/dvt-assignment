package za.co.discovery.repository.config;

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

    /*@Autowired
    private RouteRepository routeRepository;

    @Autowired
    private PlanetRepository planetRepository;

    @PostConstruct
    public void startDBManager() {

        try {

            System.out.print("####POST CONSTRUCT ####");

            CsvFileReaderUtil csvFileReaderUtil = new CsvFileReaderUtil();

            for (Planet planet :csvFileReaderUtil.getPlanets()) {
                planetRepository.save(planet);

            }

            for (Route route :csvFileReaderUtil.getRoutes()) {
                routeRepository.save(route);

            }

            System.out.print("####POST CONSTRUCT DONE ####");
        }catch (Exception e){

        }




        //derby
       DatabaseManagerSwing.main(new String[] { "--url", "jdbc:derby:memory:testdb;create=true", "--user", "", "--password", "" });


    }*/

    /* @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
         //dataSource.set
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }*/

    @Bean
    public DataSource dataSource() {
  return new EmbeddedDatabaseBuilder()
                //.generateUniqueName(true)
                .setType(EmbeddedDatabaseType.DERBY)
                .setScriptEncoding("UTF-8")
                .ignoreFailedDrops(true)
                //.addScript("/db/sql/create-db.sql")
               // .addScripts("/db/create-schema.sql","/db/create-planet.sql", "/db/create-route.sql")
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
