package com.dedae.m3.services;


import com.dedae.m3.dto.UserRolDTO;

import java.util.List;
import java.util.Optional;

public interface UserRolService {
    List<UserRolDTO> listUserRol();

    UserRolDTO save(UserRolDTO dto);

    Optional<UserRolDTO> getUserRolById(Integer id);

    void delete (Integer id);
}
