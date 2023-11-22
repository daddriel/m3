package com.dedae.m3.services.mapper;

import com.dedae.m3.domain.entities.User;
import com.dedae.m3.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements CustomMapper<UserDTO, User>{
    @Override
    public UserDTO toDto(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        dto.setCreateAt(user.getCreatedAt());
        return dto;
    }

    public UserDTO toDtoDetailed(User user){
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setEmail(user.getEmail());
        dto.setCreateAt(user.getCreatedAt());
        if (user.getUserDetail() != null){
            dto.setUserDetail(user.getUserDetail().toString());
        }

        return dto;
    }


    @Override
    public User toEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setCreatedAt(dto.getCreateAt());

        return user;

    }
}
