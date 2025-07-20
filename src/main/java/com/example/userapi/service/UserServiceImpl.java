package com.example.userapi.service;

import com.example.userapi.dto.UserRequestDTO;
import com.example.userapi.dto.UserResponseDTO;
import com.example.userapi.entity.User;
import com.example.userapi.exception.ResourceNotFoundException;
import com.example.userapi.exception.ResourceUniqueConstraintException;
import com.example.userapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Override
    public List<UserResponseDTO> getAll() {
        return userRepository.findAllByDeletedAtIsNull().stream().map(this::toResponse).toList();
    }

    @Override
    public UserResponseDTO create(UserRequestDTO dto) {
        if (userRepository.findByEmailAndDeletedAtIsNull(dto.email()).isPresent()) {
            throw new ResourceUniqueConstraintException("El email ya está en uso");
        }
        User user = User.builder()
                .email(dto.email())
                .password(encoder.encode(dto.password()))
                .name(dto.name())
                .age(dto.age())
                .build();
        User savedUser = userRepository.save(user);
        return toResponse(savedUser);
    }

    @Override
    public UserResponseDTO getById(Long id) {
        return userRepository.findByIdAndDeletedAtIsNull(id)
                .map(this::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
    }

    @Override
    public UserResponseDTO updateById(Long id, UserRequestDTO dto) {
        if(userRepository.findByEmailAndIdNotAndDeletedAtIsNull(dto.email(), id).isPresent()) {
            throw new ResourceUniqueConstraintException("El email ya está en uso");
        }
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setAge(dto.age());
        user.setPassword(encoder.encode(dto.password()));
        return toResponse(userRepository.save(user));
    }

    @Override
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuario no encontrado");
        }
        userRepository.softDeleteById(id);
    }
    private UserResponseDTO toResponse(User user) {
        return new UserResponseDTO(user.getId(), user.getEmail(), user.getName(), user.getAge());
    }
}
