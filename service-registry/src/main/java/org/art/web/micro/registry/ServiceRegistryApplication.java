package org.art.web.micro.registry;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

@EnableEurekaServer
@SpringBootApplication
public class ServiceRegistryApplication {

    @Value("${eureka.instance.hostname}")
    private String serviceHost;

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryApplication.class, args);
    }

    @Bean
    public CommandLineRunner showAppInfo() {
        return (args) -> {
            System.out.println("*** Application info ***");
            System.out.println("Service Registry domain: " + serviceHost);
        };
    }
}
