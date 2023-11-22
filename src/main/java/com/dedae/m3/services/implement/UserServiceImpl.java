package com.dedae.m3.services.implement;

import com.dedae.m3.domain.entities.User;
import com.dedae.m3.dto.UserDTO;
import com.dedae.m3.repositories.spring.data.UserRepository;
import com.dedae.m3.services.UserService;
import com.dedae.m3.services.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> listUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> listUserDetailed() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDtoDetailed).collect(Collectors.toList());
    }

    @Override
    public UserDTO save(UserDTO dto) {
        User user = userRepository.save(userMapper.toEntity(dto));

        return userMapper.toDto(user);
    }

    @Override
    public Optional<UserDTO> getUserById(Integer id) {

        return userRepository.findById(id).map(userMapper::toDto);
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
