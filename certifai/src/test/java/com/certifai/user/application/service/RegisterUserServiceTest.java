package com.certifai.user.application.service;

import com.certifai.user.application.port.out.UserGateway;
import com.certifai.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RegisterUserServiceTest {

    @Mock
    private UserGateway userGateway;

    @InjectMocks
    private RegisterUserService registerUserService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveExecutarPersistenciaDeUsuario() {
        // Arrange
        User user = new User("Felipe", "felipe@email.com", "Senha123!");
        when(userGateway.persist(user)).thenReturn(user);

        // Act
        User resultado = registerUserService.execute(user);

        // Assert
        assertEquals(user, resultado);
        verify(userGateway, times(1)).persist(user); // garante que o método foi chamado 1 vez
    }
}
