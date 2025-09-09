package com.certifai.user.gateway.persistence.jpa;

import com.certifai.user.application.port.out.UserGateway;
import com.certifai.user.application.service.mapper.OutputMapper;
import com.certifai.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserPersistenceJpaAdapter implements UserGateway {

    private final UserRepositoryJpa userRepositoryJpa;
    private final OutputMapper outputMapper;

    public UserPersistenceJpaAdapter (UserRepositoryJpa userRepositoryJpa, OutputMapper outputMapper){
        this.userRepositoryJpa = userRepositoryJpa;
        this.outputMapper = outputMapper;
    }

    public User persist(User user){
        final var result = userRepositoryJpa.save(outputMapper.toEntity(user));
        return outputMapper.toDomain(result);
    }
}
