package com.dedae.m3.repositories.spring.data;

import com.dedae.m3.domain.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {
}
