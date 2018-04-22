package com.testproject.docstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration(exclude={MultipartAutoConfiguration.class})
@EnableJpaRepositories()
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
