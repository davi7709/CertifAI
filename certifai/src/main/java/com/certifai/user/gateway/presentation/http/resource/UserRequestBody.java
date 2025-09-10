package com.certifai.user.gateway.presentation.http.resource;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRequestBody(
        @NotBlank
        String name,

        @NotBlank
        @Email(message = "Email inválido")
        String email,

        @NotBlank
        @Size(min = 5, message = "A senha deve ter no mínimo 5 caracteres")
        @Pattern(
                regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+\\-={}:;<>.,]).{5,}$",
                message = "A senha deve conter ao menos uma letra maiúscula, um número e um caractere especial"
        )
        String password
) {}
