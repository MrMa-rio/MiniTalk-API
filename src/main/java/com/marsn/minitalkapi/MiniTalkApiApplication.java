package com.marsn.minitalkapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class MiniTalkApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniTalkApiApplication.class, args);
    }

}
