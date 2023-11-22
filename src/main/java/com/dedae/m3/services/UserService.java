package com.dedae.m3.services;

import com.dedae.m3.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDTO> listUsers();

    List<UserDTO> listUserDetailed();

    UserDTO save(UserDTO dto);

    Optional<UserDTO> getUserById(Integer id);

    void delete(Integer id);
}
