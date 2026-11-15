
package br.com.backend.jema.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.autoconfigure.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class MySqlConfig {

    // Configuração do PostgreSQL
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties postgresProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    public DataSource postgresDataSource(
            @Qualifier("postgresProperties")
            DataSourceProperties properties) {

        return properties.initializeDataSourceBuilder().build();
    }

    // Configuração do MySQL
    @Bean
    @ConfigurationProperties("app.datasource.mysql")
    public DataSourceProperties mysqlProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "mysqlDataSource")
    public DataSource mysqlDataSource(
            @Qualifier("mysqlProperties")
            DataSourceProperties properties) {

        return properties.initializeDataSourceBuilder().build();
    }

    // Acesso ao MySQL através do JdbcTemplate
    @Bean(name = "mysqlJdbcTemplate")
    public JdbcTemplate mysqlJdbcTemplate(
            @Qualifier("mysqlDataSource")
            DataSource dataSource) {

        return new JdbcTemplate(dataSource);
    }

    @Bean
    public org.springframework.boot.CommandLineRunner testarMySQL(
            @Qualifier("mysqlJdbcTemplate") JdbcTemplate jdbcTemplate) {

        return args -> {
            Integer resultado = jdbcTemplate.queryForObject(
                    "SELECT 1", Integer.class
            );

            System.out.println("MySQL conectado! Resultado: " + resultado);
        };
    }
}
