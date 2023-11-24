package com.dedae.m3.services.implement;

import com.dedae.m3.dto.UserRolDTO;
import com.dedae.m3.repositories.spring.data.UserRolRepository;
import com.dedae.m3.services.UserRolService;
import com.dedae.m3.services.mapper.UserRolMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserRolServiceImpl implements UserRolService {

    private final UserRolRepository userRolRepository;

    private final UserRolMapper userRolMapper;


    public UserRolServiceImpl(UserRolRepository userRolRepository, UserRolMapper userRolMapper) {
        this.userRolRepository = userRolRepository;
        this.userRolMapper = userRolMapper;
    }

    @Override
    public List<UserRolDTO> listUserRol() {
        return userRolRepository.findAll()
                .stream()
                .map(userRolMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserRolDTO save(UserRolDTO dto) {
        return null;
    }

    @Override
    public Optional<UserRolDTO> getUserRolById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void delete(Integer id) {

    }
}
