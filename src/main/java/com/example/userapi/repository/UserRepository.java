package com.example.userapi.repository;

import com.example.userapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Interfaz que extiende JpaRepository para operaciones de base de datos
// <User, Long> significa: entidad User con ID de tipo Long
public interface UserRepository extends JpaRepository<User, Long> {
    // No necesitas escribir métodos - JpaRepository ya incluye:
    // - save(user) - guardar/actualizar
    // - findById(id) - buscar por ID
    // - findAll() - obtener todos
    // - deleteById(id) - eliminar por ID
    // - count() - contar registros
    // - existsById(id) - verificar si existe
}