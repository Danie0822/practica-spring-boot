// src/main/java/com/example/userapi/config/SecurityConfig.java
package com.example.userapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Profile("dev") // Solo se activa en el perfil de desarrollo
public class SecurityConfig {

    // ✅ Permitir todo el tráfico
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desactiva protección CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Permitir todas las rutas sin autenticación
                )
                .httpBasic(httpBasic -> httpBasic.disable()) // Desactiva login básico
                .formLogin(form -> form.disable()); // Desactiva login por formulario

        return http.build();
    }

    // ✅ Bean de PasswordEncoder necesario
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
