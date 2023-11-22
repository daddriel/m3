package com.dedae.m3.repositories.spring.data;

import com.dedae.m3.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
