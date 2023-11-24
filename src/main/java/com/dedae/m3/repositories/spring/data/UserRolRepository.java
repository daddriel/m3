package com.dedae.m3.repositories.spring.data;

import com.dedae.m3.domain.entities.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;

public interface UserRolRepository extends JpaRepository <UserRol, Integer> {
}
