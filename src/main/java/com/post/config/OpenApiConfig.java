package com.post.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.GroupedOpenApi;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "REST API DOCS",
                version = "1.0",
                description = "REST API for post project"
        )
)
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("Public")
                .pathsToMatch("/**")
                .build();
    }
}

