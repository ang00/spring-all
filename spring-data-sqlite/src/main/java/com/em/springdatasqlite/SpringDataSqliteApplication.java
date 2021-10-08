package com.em.springdatasqlite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAsync
@RestController
@EnableJpaAuditing
@SpringBootApplication
public class SpringDataSqliteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataSqliteApplication.class, args);
    }

    @GetMapping
    public String index() {
        return "Backend service started successfully";
    }
}
