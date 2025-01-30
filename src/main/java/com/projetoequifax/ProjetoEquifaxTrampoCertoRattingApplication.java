package com.projetoequifax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.projetoequifax.domains.entity"})
public class ProjetoEquifaxTrampoCertoRattingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetoEquifaxTrampoCertoRattingApplication.class, args);
    }

}
