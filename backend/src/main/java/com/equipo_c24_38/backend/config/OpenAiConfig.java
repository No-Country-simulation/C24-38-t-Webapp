package com.equipo_c24_38.backend.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "App MedLife",
                version = "1.0.0",
                description = "Aplicación para gestionar citas e historiales clínicos tanto" +
                        " pacientes como médicos.",
                summary = "asdasdad"
        )
)
public class OpenAiConfig {
}
