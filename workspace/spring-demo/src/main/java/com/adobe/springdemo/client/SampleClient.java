package com.adobe.springdemo.client;

import com.adobe.springdemo.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleClient implements CommandLineRunner {
    @Autowired
    private AppService service;

    // executes as soon as spring container is created and initialized
    @Override
    public void run(String... args) throws Exception {
        service.doTask();
    }
}
