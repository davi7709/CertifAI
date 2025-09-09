package com.certifai.user.gateway.presentation.http.resource;

public record UserRequestBody(String name, String email, String password) {
}
