package com.certifai.user.application.service.mapper;

import com.certifai.user.domain.User;
import com.certifai.user.gateway.persistence.jpa.UserEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class OutputMapperTest {

    private final OutputMapper mapper = Mappers.getMapper(OutputMapper.class);

    @Test
    void deveConverterEntityParaDomain() {

        UserEntity entity = new UserEntity();
        entity.setId(1L);
        entity.setName("Felipe");
        entity.setEmail("felipe@email.com");
        entity.setPassword("Senha123!");


        User domain = mapper.toDomain(entity);


        assertEquals("Felipe", domain.name());
        assertEquals("felipe@email.com", domain.email());
        assertEquals("Senha123!", domain.password());
    }

    @Test
    void deveConverterDomainParaEntityIgnorandoId() {

        User domain = new User("Felipe", "felipe@email.com", "Senha123!");

        UserEntity entity = mapper.toEntity(domain);

        assertNull(entity.getId(), "O ID deve ser ignorado e ficar null");
        assertEquals("Felipe", entity.getName());
        assertEquals("felipe@email.com", entity.getEmail());
        assertEquals("Senha123!", entity.getPassword());
    }
}
