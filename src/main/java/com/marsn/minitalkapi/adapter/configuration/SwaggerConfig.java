package com.marsn.minitalkapi.adapter.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    static String packagePath = "com.marsn.minitalkapi.entrypoint.";

    @Bean
    public GroupedOpenApi authApi() {
        return GroupedOpenApi.builder()
                .group("Autenticação")
                .packagesToScan(packagePath + "auth")
                .build();
    }

    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("Usuários")
                .packagesToScan(packagePath + "user")
                .build();
    }

    @Bean
    public GroupedOpenApi messageApi() {
        return GroupedOpenApi.builder()
                .group("Mensagens")
                .packagesToScan(packagePath + "chat")
                .build();
    }
}
