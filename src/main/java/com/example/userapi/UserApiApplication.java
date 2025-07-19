package com.example.userapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;
@SpringBootApplication
public class UserApiApplication {

    public static void main(String[] args) {
        // Cargar el .env
        Dotenv dotenv = Dotenv.configure().load();

        System.setProperty("spring.datasource.url", dotenv.get("DATABASE_URL"));
        System.setProperty("spring.datasource.username", dotenv.get("DATABASE_USER"));
        System.setProperty("spring.datasource.password", dotenv.get("DATABASE_PASSWORD"));
        System.setProperty("spring.datasource.userNameLogin",dotenv.get("USER_NAME"));
        System.setProperty("spring.datasource.userPassword",dotenv.get("USER_PASSWORD"));

        SpringApplication.run(UserApiApplication.class, args);
    }

}


