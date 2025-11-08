package com.marsn.minitalkapi;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableReactiveMongoRepositories
@EnableRabbit
public class MiniTalkApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MiniTalkApiApplication.class, args);
    }

}
