package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
/*@ComponentScan(basePackages = {"com.example.demo.endpoint", "com.example.demo.service", "com.example.demo.data","com.example.demo.Dto"})
@EntityScan("com.example.impl")
@EnableJpaRepositories("com.example.demo.repository")
@EnableWebMvc*/
@EnableDiscoveryClient
@EnableFeignClients
//@EnableZuulProxy
@EnableCircuitBreaker
public class MypcfApplication {

    public static void main(String[] args) {
        SpringApplication.run(MypcfApplication.class, args);
    }

}

