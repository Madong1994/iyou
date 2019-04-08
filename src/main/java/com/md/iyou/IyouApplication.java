package com.md.iyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IyouApplication {

    public static void main(String[] args) {
        SpringApplication.run(IyouApplication.class, args);
    }
}
