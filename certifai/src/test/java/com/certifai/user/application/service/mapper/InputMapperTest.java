package com.certifai.user.application.service.mapper;

import com.certifai.user.domain.User;
import com.certifai.user.gateway.presentation.http.resource.UserRequestBody;
import com.certifai.user.gateway.presentation.http.resource.UserResource;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputMapperTest {

    private final InputMapper mapper = Mappers.getMapper(InputMapper.class);

    @Test
    void deveConverterRequestBodyParaDomain() {
        // Arrange: passa todos os campos no construtor do record
        UserRequestBody req = new UserRequestBody("Felipe", "felipe@email.com", "Senha123!");

        User user = mapper.toDomain(req);

        // Assert: acessa métodos name() e email() do record
        assertEquals("Felipe", user.name());
        assertEquals("felipe@email.com", user.email());
    }

    @Test
    void deveConverterDomainParaResource() {
        // Arrange: passa todos os campos no construtor do record
        User user = new User("Felipe", "felipe@email.com", "Senha123!");

        UserResource resource = mapper.toResource(user);

        // Assert: acessa métodos name() e email() do record
        assertEquals("Felipe", resource.name());
        assertEquals("felipe@email.com", resource.email());
    }
}