package com.example.userapi.entity;

import java.time.LocalDateTime;

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
    @Column(name = "created_at",nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @PrePersist
    private void prePersist() {
        // Este método se ejecuta antes de guardar el objeto en la base de datos
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    public boolean isDeleted() {
        // Verifica si el usuario ha sido eliminado
        return deletedAt != null;
    }
}
