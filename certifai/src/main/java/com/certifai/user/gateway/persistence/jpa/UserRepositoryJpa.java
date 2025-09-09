package com.certifai.user.gateway.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJpa extends JpaRepository<UserEntity,Long> {
}
