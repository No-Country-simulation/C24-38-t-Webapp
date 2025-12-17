package com.equipo_c24_38.backend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "App MedLife",
                version = "1.0.0",
                description = "Aplicación para gestionar citas e historiales clínicos tanto" +
                        " pacientes como médicos."
        )
)
public class OpenAiConfig {

        @Bean
        public OpenAPI customeOpenApi() {

                return new OpenAPI()
                        .addServersItem(new Server().url("https://backend-medlife-production.up.railway.app").description("Servidor HTTPS"));

        }

}
