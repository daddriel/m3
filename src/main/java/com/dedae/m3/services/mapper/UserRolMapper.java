package com.dedae.m3.services.mapper;

import com.dedae.m3.domain.entities.UserRol;
import com.dedae.m3.dto.UserRolDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Component
public class UserRolMapper implements  CustomMapper <UserRolDTO, UserRol> {

    @Override
    public UserRolDTO toDto(UserRol userRol) {
        UserRolDTO dto = new UserRolDTO();

        dto.setId(userRol.getId());
        dto.setActive(userRol.getActive());
        dto.setCreatedAt(userRol.getCreatedAt());

        return dto;
    }

    @Override
    public UserRol toEntity(UserRolDTO dto) {

        UserRol userRol = new UserRol();
        userRol.setId(dto.getId());
        userRol.setActive(dto.getActive());
        userRol.setCreatedAt(dto.getCreatedAt());

        return userRol;
    }
}
