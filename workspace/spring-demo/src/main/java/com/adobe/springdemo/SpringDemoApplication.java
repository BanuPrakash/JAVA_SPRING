package com.adobe.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemoApplication {
    public static void main(String[] args) {
        // this line is what creates Spring Container
        SpringApplication.run(SpringDemoApplication.class, args);
    }
}
