package com.dedae.m3.services.implement;

import com.dedae.m3.dto.RolDTO;
import com.dedae.m3.repositories.spring.jdbc.RolJbdcRepository;
import com.dedae.m3.services.RolService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    private final RolJbdcRepository rolJbdcRepository;

    public RolServiceImpl(RolJbdcRepository rolJbdcRepository) {
        this.rolJbdcRepository = rolJbdcRepository;
    }

    @Override
    public List<RolDTO> listRoles() {
        return rolJbdcRepository.listRoles();
    }
    @Override
    public Optional<RolDTO> getRolById(Integer id) {
        return rolJbdcRepository.getRolById(id);
    }

    @Override
    public int save(RolDTO rolDTO) {
        return rolJbdcRepository.save(rolDTO);
    }

    @Override
    public int delete(Integer id) {
        return rolJbdcRepository.delete(id);
    }
}
