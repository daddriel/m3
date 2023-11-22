package com.dedae.m3.services.implement;

import com.dedae.m3.domain.entities.User;
import com.dedae.m3.domain.entities.UserDetail;
import com.dedae.m3.dto.UserDetailDTO;
import com.dedae.m3.repositories.spring.data.UserDetailRepository;
import com.dedae.m3.services.UserDetailService;
import com.dedae.m3.services.mapper.UserDetailMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    private final UserDetailRepository userDetailRepository;

    private final UserDetailMapper userDetailMapper;

    public UserDetailServiceImpl(UserDetailRepository userDetailRepository, UserDetailMapper userDetailMapper) {
        this.userDetailRepository = userDetailRepository;
        this.userDetailMapper = userDetailMapper;
    }


    @Override
    public List<UserDetailDTO> listUserDetails() {
        return userDetailRepository.findAll()
                .stream()
                .map(userDetailMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDetailDTO save(UserDetailDTO dto) {
        UserDetail userDetail = userDetailRepository.save(userDetailMapper.toEntity(dto));
        return userDetailMapper.toDto(userDetail);

    }

    @Override
    public Optional<UserDetailDTO> getUserDetailById(Long id) {
        return userDetailRepository.findById(id).map(userDetailMapper::toDto);
    }

    @Override
    public void delete(Long id) {

        userDetailRepository.deleteById(id);

    }
}
