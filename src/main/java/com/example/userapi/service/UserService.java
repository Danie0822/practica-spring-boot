package com.example.userapi.service;

import com.example.userapi.dto.UserRequestDTO;
import com.example.userapi.dto.UserResponseDTO;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> getAll();
    UserResponseDTO create(UserRequestDTO userRequestDTO);
    UserResponseDTO getById(Long id);
    UserResponseDTO updateById(Long id, UserRequestDTO userRequestDTO);
    void delete(Long id);
}
