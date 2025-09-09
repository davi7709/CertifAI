package com.certifai.user.gateway.presentation.http;

import com.certifai.user.application.port.in.RegisterUser;
import com.certifai.user.application.service.mapper.InputMapper;
import com.certifai.user.gateway.presentation.http.resource.UserRequestBody;
import com.certifai.user.gateway.presentation.http.resource.UserResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final RegisterUser registerUser;
    private final InputMapper inputMapper;

    public UserController(RegisterUser registerUser, InputMapper inputMapper){
        this.registerUser = registerUser;
        this.inputMapper = inputMapper;
    }

    @PostMapping
    public ResponseEntity<UserResource> register(@RequestBody UserRequestBody userRequestBody){
        final var user = registerUser.execute(inputMapper.toDomain(userRequestBody));
        final var userResource = inputMapper.toResource(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResource);
    }
}
