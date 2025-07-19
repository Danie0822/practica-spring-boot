package com.example.userapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data // Data es para evitar los getters y setters
@NoArgsConstructor // NoArgsConstructor es para evitar el constructor por defecto
@AllArgsConstructor // AllArgsConstructor es para evitar el constructor con todos los atributos
@Builder // Builder es para poder crear objetos de forma más sencilla
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column
    private Integer age;
}
