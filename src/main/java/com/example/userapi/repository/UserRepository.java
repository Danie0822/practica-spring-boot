package com.example.userapi.repository;

import com.example.userapi.entity.User;
import com.example.userapi.exception.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

// Interfaz que extiende JpaRepository para operaciones de base de datos
// <User, Long> significa: entidad User con ID de tipo Long
public interface UserRepository extends JpaRepository<User, Long> {
    // Buscar un usuario por su email que no esté eliminado (soft delete)
    Optional<User> findByEmailAndDeletedAtIsNull(String email);

    // Buscar el usuario por su email pero que no sea el mismo ID
    Optional<User> findByEmailAndIdNotAndDeletedAtIsNull(String email, Long id);

    // Obtener todos los usuarios que no estén eliminados (soft delete)
    List<User> findAllByDeletedAtIsNull();

    // Obtener usuario por ID que no esté eliminado (soft delete)
    Optional<User> findByIdAndDeletedAtIsNull(long id);

    default void softDeleteById(Long id) {
        // Método para eliminar un usuario por ID (soft delete)
        User user = findByIdAndDeletedAtIsNull(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        user.setDeletedAt(LocalDateTime.now());
        save(user);
    }
}