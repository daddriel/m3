package com.dedae.m3.services;

import com.dedae.m3.dto.RolDTO;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List<RolDTO> listRoles();

    Optional<RolDTO> getRolById(Integer id);

    int save(RolDTO rolDTO);
    int delete(Integer id);
}
