package com.certifai.user.gateway.persistence.jpa;

import com.certifai.user.application.service.mapper.OutputMapper;
import com.certifai.user.domain.User;
import com.certifai.user.gateway.persistence.jpa.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserPersistenceJpaAdapterTest {

    @Mock
    private UserRepositoryJpa userRepositoryJpa;

    @Mock
    private OutputMapper outputMapper;

    @InjectMocks
    private UserPersistenceJpaAdapter adapter;

    private User domainUser;
    private UserEntity entityUser;

    @BeforeEach
    void setup() {
        domainUser = new User("Felipe", "felipe@email.com", "Senha123!");

        entityUser = new UserEntity();
        entityUser.setId(null);
        entityUser.setName("Felipe");
        entityUser.setEmail("felipe@email.com");
        entityUser.setPassword("Senha123!");
    }

    @Test
    void devePersistirUsuarioComSucesso() {

        when(outputMapper.toEntity(domainUser)).thenReturn(entityUser);
        when(userRepositoryJpa.save(entityUser)).thenReturn(entityUser);
        when(outputMapper.toDomain(entityUser)).thenReturn(domainUser);


        User result = adapter.persist(domainUser);


        assertEquals("Felipe", result.name());
        assertEquals("felipe@email.com", result.email());
        verify(userRepositoryJpa, times(1)).save(any(UserEntity.class));
    }
}

