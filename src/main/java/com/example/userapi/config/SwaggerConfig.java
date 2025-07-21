package com.example.userapi.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.*;

@Configuration
@Profile("dev") // Se activa solo en el perfil de desarrollo
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("User API")
                        .description("API REST para gestión de usuarios")
                        .version("1.0.0"));
    }
}
