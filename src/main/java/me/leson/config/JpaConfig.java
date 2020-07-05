package me.leson.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class JpaConfig {
    @Bean(name = "mySqlDataSource")
    @Primary
    public DataSource mySqlDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        //dataSourceBuilder.url("jdbc:mysql://localhost:3306/db_yoncoffee");
        dataSourceBuilder.url("jdbc:mysql://mysql-db:3306/yoncoffee");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("20071998");
        return dataSourceBuilder.build();
    }
}
