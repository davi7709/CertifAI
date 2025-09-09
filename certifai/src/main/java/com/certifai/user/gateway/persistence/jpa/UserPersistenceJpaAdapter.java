package com.certifai.user.gateway.persistence.jpa;

import com.certifai.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserPersistenceJpaAdapter {

    private final UserRepositoryJpa userRepositoryJpa;

    public UserPersistenceJpaAdapter (UserRepositoryJpa userRepositoryJpa){
        this.userRepositoryJpa = userRepositoryJpa;
    }

    public UserEntity persist(UserEntity user){
        return userRepositoryJpa.save(user);
    }
}
