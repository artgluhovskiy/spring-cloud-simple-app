package org.art.web.micro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@EnableCircuitBreaker
@SpringBootApplication
public class CatalogServiceApplication {

    @Autowired
    private DataSource dataSource;

    @Value("${spring.application.name}")
    private String appName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String serviceRegistryDomain;

    public static void main(String[] args) {
        SpringApplication.run(CatalogServiceApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner showAppInfo() {
        return args -> {
            System.out.println("*** Application info ***");
            System.out.println("Data source: " + dataSource);
            System.out.println("App name: " + appName);
            System.out.println("Service Registry domain: " + serviceRegistryDomain);
        };
    }
}
