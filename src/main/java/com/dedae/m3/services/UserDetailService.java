package com.dedae.m3.services;


import com.dedae.m3.dto.UserDetailDTO;

import java.util.List;
import java.util.Optional;

public interface UserDetailService {

    List<UserDetailDTO> listUserDetails();

    UserDetailDTO save(UserDetailDTO dto);

    Optional<UserDetailDTO> getUserDetailById(Long id);

    void delete(Long id);
}
