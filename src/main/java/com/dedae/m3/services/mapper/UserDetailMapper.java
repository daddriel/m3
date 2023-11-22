package com.dedae.m3.services.mapper;

import com.dedae.m3.domain.entities.UserDetail;
import com.dedae.m3.dto.UserDetailDTO;
import org.springframework.stereotype.Component;

@Component
public class UserDetailMapper implements CustomMapper <UserDetailDTO, UserDetail>{
    @Override
    public UserDetailDTO toDto(UserDetail userDetail){
        UserDetailDTO dto = new UserDetailDTO();
        dto.setId(userDetail.getId());
        dto.setFirstName(userDetail.getFirstName());
        dto.setLastName(userDetail.getLastName());
        dto.setBirthDay(userDetail.getBirthDay());

        return dto;
    }

    @Override
    public UserDetail toEntity(UserDetailDTO dto){
        UserDetail userDetail = new UserDetail();
        userDetail.setId(dto.getId());
        userDetail.setFirstName(dto.getFirstName());
        userDetail.setLastName(dto.getLastName());
        userDetail.setBirthDay(dto.getBirthDay());

        return userDetail;
    }


}
