package org.art.web.micro.inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class InventoryServiceApplication {

    @Autowired
    private DataSource dataSource;

    @Value("${eureka.client.service-url.defaultZone}")
    private String serviceRegistryDomain;

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner showAppInfo() {
        return (args) -> {
            System.out.println("*** Application info ***");
            System.out.println("Data source: " + dataSource);
            System.out.println("Service Registry domain: " + serviceRegistryDomain);
        };
    }
}
