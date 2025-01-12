package ru.clevertec.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;


@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "News Control System API",
                version = "1.0.0",
                description = "Документация API для системы контроля новостей. Микросервис Security"
        ),
        servers = @Server(url = "http://localhost:8083")
)
public class OpenApiConfig {
}

